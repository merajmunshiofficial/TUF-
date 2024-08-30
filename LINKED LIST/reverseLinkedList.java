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

class reverseLinkedList {
    // Function to reverse a linked list 
    // using the 3-pointer approach
    public ListNode reverseLinkedList(ListNode head) {
        /* Initialize 'temp' at 
         * head of linked list */
        ListNode temp = head;
        
        /* Initialize pointer 'prev' 
         * to NULL, representing 
         * the previous node */
        ListNode prev = null;
        
        // Continue till 'temp' 
        // reaches the end (NULL)
        while (temp != null) {
            /* Store the next node in 'front' 
             * to preserve the reference */
            ListNode front = temp.next;
            
            /* Reverse the direction of the 
             * current node's 'next' pointer 
             * to point to 'prev' */
            temp.next = prev;
            
            /* Move 'prev' to the current 
             * node for the next iteration */
            prev = temp;
            
            /* Move 'temp' to the 'front' node 
             * advancing the traversal */
            temp = front;
        }
        
        // Return the new head 
        // of the reversed linked list
        return prev;
    }

    // Function to get the Kth node from a 
    // given position in the linked list
    public ListNode getKthNode(ListNode temp, int k) {
        // Decrement K 
        // as we already start 
        // from the 1st node
        k -= 1;

        // Decrement K until it reaches the desired position
        while (temp != null && k > 0) {
            // Decrement k as temp progresses
            k--;
            
            // Move to the next node
            temp = temp.next;
        }
        
        // Return the Kth node
        return temp;
    }

    // Function to reverse nodes in groups of K
    public ListNode reverseKGroup(ListNode head, int k) {
        /* Initialize a temporary 
         * node to traverse the list */
        ListNode temp = head;

        /* Initialize a pointer to track 
         * the last node of the previous group */
        ListNode prevLast = null;
        
        // Traverse through the linked list
        while (temp != null) {
            // Get the Kth node of the current group
            ListNode kThNode = getKthNode(temp, k);

            /* If the Kth node is NULL 
             * (not a complete group) */
            if (kThNode == null) {
                /* If there was a previous group, 
                 * link the last node to the current node */
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                
                // Exit the loop
                break;
            }
            
            /* Store the next node 
             * after the Kth node */
            ListNode nextNode = kThNode.next;

            /* Disconnect the Kth node 
             * to prepare for reversal */
            kThNode.next = null;

            // Reverse the nodes from temp to the Kth node
            reverseLinkedList(temp);
            
            /* Adjust the head if the reversal 
             * starts from the head */
            if (temp == head) {
                head = kThNode;
            } else {
                /* Link the last node of the previous 
                 * group to the reversed group */
                prevLast.next = kThNode;
            }

            /* Update the pointer to the 
             * last node of the previous group */
            prevLast = temp;

            // Move to the next group
            temp = nextNode;
        }
        
        // Return the head of the modified linked list
        return head;
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
        // Create a linked list with values 5, 4, 3, 7, 9 and 2
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(2);

        // Print the original linked list
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Reverse the linked list in groups of K
        reverseLinkedList reverseLinkedList = new reverseLinkedList();
        head = reverseLinkedList.reverseKGroup(head, 4);

        // Print the reversed linked list
        System.out.print("Reversed Linked List: ");
        printLinkedList(head);
    }
}
