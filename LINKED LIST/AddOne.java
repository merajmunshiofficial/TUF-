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

class AddOne {
    // Helper function to add one to the linked list
    private int addHelper(ListNode temp) {
        // If the list is empty, return a carry of 1
        if (temp == null) 
            return 1;
        
        // Recursively call addHelper for the next node
        int carry = addHelper(temp.next); 
        
        // Add the carry to the current node's value
        temp.val += carry; 
        
        // If the current node's value is less than 10, no further carry is needed
        if (temp.val < 10) 
            return 0;
        
        // If the current node's value is 10 or more, set it to 0 and return a carry of 1
        temp.val = 0; 
        return 1;
    }

    public ListNode addOne(ListNode head) {
        // Call the helper function to start the addition process
        int carry = addHelper(head);
        
        // If there is a carry left after processing all nodes, add a new node at the head
        if (carry == 1) { 
            ListNode newNode = new ListNode(1);
            // Link the new node to the current head
            newNode.next = head; 
            // Update the head to the new node
            head = newNode; 
        }
        // Return the head
        return head; 
    }

     // Function to print the linked list
     public static void printLinkedList(ListNode head) {
        ListNode temp = head;
        // Traverse the linked list and print each node's value
        while (temp != null) { 
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a linked list with values 9, 9, 9 (999 + 1 = 1000)
        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);

        // Print the original linked list
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Add one to the linked list
        AddOne sol = new AddOne();
        head = sol.addOne(head);

        // Print the modified linked list
        System.out.print("Linked List after adding one: ");
        printLinkedList(head);
    }
}

