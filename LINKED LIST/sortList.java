import java.util.*;

// Definition of singly linked list:
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

class sortList {
    // Function to sort the linked list
    public ListNode sortList(ListNode head) {
        /* If the list is empty or has only one 
           node, return as it is already sorted */
        if (head == null || head.next == null)
            return head;

        // Dummy nodes to point to heads of 
        // three lists
        ListNode zeroHead = new ListNode(-1);
        ListNode oneHead = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);

        // Pointers to current last nodes of 
        // three lists
        ListNode zero = zeroHead;
        ListNode one = oneHead;
        ListNode two = twoHead;
        ListNode temp = head;

        /* Traverse the original list 
           and distribute the nodes 
           into three lists */
        while (temp != null) {
            if (temp.val == 0) {
                zero.next = temp;
                zero = temp;
            } else if (temp.val == 1) {
                one.next = temp;
                one = temp;
            } else if (temp.val == 2) {
                two.next = temp;
                two = temp;
            }
            temp = temp.next;
        }

        // Connect the three lists together
        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        // New head of the sorted list
        ListNode newHead = zeroHead.next;

        // Delete dummy nodes
        return newHead;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Helper function to create a new node
    public static ListNode newNode(int data) {
        return new ListNode(data);
    }

    public static void main(String[] args) {
        // Creating a linked list
        ListNode head = newNode(1);
        head.next = newNode(2);
        head.next.next = newNode(0);
        head.next.next.next = newNode(1);
        head.next.next.next.next = newNode(2);
        head.next.next.next.next.next = newNode(0);
        head.next.next.next.next.next.next = newNode(1);

        // Print original list
        System.out.print("Original list: ");
        printList(head);

        // Sort the list
        sortList sol = new sortList();
        head = sol.sortList(head);

        // Print sorted list
        System.out.print("Sorted list: ");
        printList(head);
    }

}

