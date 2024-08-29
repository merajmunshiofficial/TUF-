import java.util.*;

// Definition of singly linked list
class ListNode {
    int val;
    ListNode next;
    ListNode() {
        val = 0;
        next = null;
    }
    ListNode(int data1) {
        val = data1;
        next = null;
    }
    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}

class RotateRight {
    // Function to rotate the list by k steps
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) 
            return head;

        // Calculating length
        ListNode temp = head;
        int length = 1;
        while (temp.next != null) {
            ++length;
            temp = temp.next;
        }

        // Link last node to first node
        temp.next = head;
        // When k is more than length of list
        k = k % length; 
        // To get end of the list
        int end = length - k; 
        while (end-- > 0) 
            temp = temp.next;

        // Breaking last node link and pointing to NULL
        head = temp.next;
        temp.next = null;

        return head;
    }
    
    // Utility function to insert node at the end of the list
    public static ListNode insertNode(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            return newNode;
        }
        ListNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        return head;
    }

    // Utility function to print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print("->");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RotateRight rotateRight = new RotateRight();
        
        ListNode head = new ListNode(1);
        // Inserting nodes
        head = insertNode(head, 2);
        head = insertNode(head, 3);
        head = insertNode(head, 4);
        head = insertNode(head, 5);

        System.out.print("Original list: ");
        printList(head);

        int k = 2;
        // Calling function for rotating right by k times
        ListNode newHead = rotateRight.rotateRight(head, k);

        System.out.print("After " + k + " iterations: ");
        // List after rotating nodes
        printList(newHead);
    }
}
