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

class OddEvenList {
    // Function to rearrange nodes
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        /*Initialize pointers for odd 
        and even nodes and keep 
        track of the first even node*/
        ListNode odd = head;
        ListNode even = head.next;
        ListNode firstEven = head.next;

        // Rearranging nodes
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        /* Connect the last odd 
       node to the first even node*/
        odd.next = firstEven;

        return head;
    }

     // Function to print the linked list
     public static void printLL(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Main function
    public static void main(String[] args) {
        // Create a linked list with given values
        int[] arr = {1, 3, 4, 2, 5, 6};
        ListNode head = new ListNode(arr[0]);
        head.next = new ListNode(arr[1]);
        head.next.next = new ListNode(arr[2]);
        head.next.next.next = new ListNode(arr[3]);
        head.next.next.next.next = new ListNode(arr[4]);
        head.next.next.next.next.next = new ListNode(arr[5]);

        // Print the original linked list
        System.out.println("Original Linked List: ");
        printLL(head);

        // Rearrange the list and print it
        OddEvenList oddEvenList = new OddEvenList();
        head = oddEvenList.oddEvenList(head);
        System.out.println("New Linked List: ");
        printLL(head);
    }

    
}

