import java.util.*;

// Definition of special linked list
class ListNode {
    int val;
    ListNode next;
    ListNode child;

    ListNode() {
        val = 0;
        next = null;
        child = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
        child = null;
    }

    ListNode(int data1, ListNode next1, ListNode next2) {
        val = data1;
        next = next1;
        child = next1;
    }
}

class flattenLinkedList {
    /* Merge the two linked lists in a particular
     order based on the data value */
    private ListNode merge(ListNode list1, ListNode list2) {
        /* Create a dummy node as a 
        placeholder for the result */
        ListNode dummyNode = new ListNode(-1);
        ListNode res = dummyNode;

        // Merge the lists based on data values
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                res.child = list1;
                res = list1;
                list1 = list1.child;
            } else {
                res.child = list2;
                res = list2;
                list2 = list2.child;
            }
            res.next = null;
        }

        // Connect the remaining elements if any
        if (list1 != null) {
            res.child = list1;
        } else {
            res.child = list2;
        }

        // Break the last node's link to prevent cycles
        if (dummyNode.child != null) {
            dummyNode.child.next = null;
        }

        return dummyNode.child;
    }

    // Function to flatten a linked list with child pointers 
    public ListNode flattenLinkedList(ListNode head) {
        // If head is null or there is no next node
        if (head == null || head.next == null) {
            return head; // Return head
        }

        // Recursively flatten the rest of the linked list
        ListNode mergedHead = flattenLinkedList(head.next);

        // Merge the lists
        head = merge(head, mergedHead);
        return head;
    }

    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.child;
        }
        System.out.println();
    }

    // Function to print the linked list in a grid-like structure
    public static void printOriginalLinkedList(ListNode head, int depth) {
        while (head != null) {
            System.out.print(head.val);

            /* If child exists, recursively
             print it with indentation */
            if (head.child != null) {
                System.out.print(" -> ");
                printOriginalLinkedList(head.child, depth + 1);
            }

            // Add vertical bars for each level in the grid
            if (head.next != null) {
                System.out.println();
                for (int i = 0; i < depth; ++i) {
                    System.out.print("| ");
                }
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        // Create a linked list with child pointers
        ListNode head = new ListNode(5);
        head.child = new ListNode(14);

        head.next = new ListNode(10);
        head.next.child = new ListNode(4);

        head.next.next = new ListNode(12);
        head.next.next.child = new ListNode(20);
        head.next.next.child.child = new ListNode(13);

        head.next.next.next = new ListNode(7);
        head.next.next.next.child = new ListNode(17);

        // Print the original linked list structure
        System.out.println("Original linked list:");
        printOriginalLinkedList(head, 0);

        // Creating an instance of flattenLinkedList class
        flattenLinkedList sol = new flattenLinkedList();

        // Function call to flatten the linked list
        ListNode flattened = sol.flattenLinkedList(head);

        // Printing the flattened linked list
        System.out.print("\nFlattened linked list: ");
        printLinkedList(flattened);
    }


}

