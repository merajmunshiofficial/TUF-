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

class ReverseListSolution {
    /* Function to reverse a singly linked list using recursion */
    public ListNode reverseList(ListNode head) {
        /* Base case:
        If the linked list is empty or has only one node,
        return the head as it is already reversed. */
        if (head == null || head.next == null) {
            return head;
        }
        
        /* Recursive step:
        Reverse the linked list starting 
        from the second node (head.next). */
        ListNode newHead = reverseList(head.next);
        
        /* Save a reference to the node following
        the current 'head' node. */
        ListNode front = head.next;
        
        /* Make the 'front' node point 
        to the current
        'head' node in the 
        reversed order. */
        front.next = head;
        
        /* Break the link from 
        the current 'head' node
        to the 'front' node 
        to avoid cycles. */
        head.next = null;
        
        /* Return the 'newHead,' 
        which is the new
        head of the reversed 
        linked list. */
        return newHead;
    }

    // Function to print the linked list
    public static void printLinkedList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        // Create a linked list with values 1, 3, 2, and 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);

        // Print the original linked list
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // ReverseListSolution instance
        ReverseListSolution sol = new ReverseListSolution();
        // Reverse the linked list
        head = sol.reverseList(head);

        // Print the reversed linked list
        System.out.print("Reversed Linked List: ");
        printLinkedList(head);
    }
}
