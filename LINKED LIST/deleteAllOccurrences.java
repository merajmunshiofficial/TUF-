import java.util.*;

// Definition of doubly linked list
class ListNode {
    int val;
    ListNode next;
    ListNode prev;
    ListNode() {
        val = 0;
        next = null;
        prev = null;
    }
    ListNode(int data1) {
        val = data1;
        next = null;
        prev = null;
    }
    ListNode(int data1, ListNode next1, ListNode prev1) {
        val = data1;
        next = next1;
        prev = prev1;
    }
}

class deleteAllOccurrences {
    // Function to delete all occurrences of a target value
    public ListNode deleteAllOccurrences(ListNode head, int target) {
        ListNode temp = head;

        while (temp != null) {
            if (temp.val == target) {
                // Update head if needed
                if (temp == head) {
                    head = temp.next;
                }

                ListNode nextNode = temp.next;
                ListNode prevNode = temp.prev;

                // Update previous node's next
                if (nextNode != null) {
                    nextNode.prev = prevNode;
                }

                // Update next node's previous
                if (prevNode != null) {
                    prevNode.next = nextNode;
                }

                // Delete the current node
                temp = nextNode;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Helper function to create a new node
    public static ListNode newNode(int data) {
        return new ListNode(data);
    }

    public static void main(String[] args) {
        // Creating doubly linked list
        ListNode head = newNode(1);
        head.next = newNode(2);
        head.next.prev = head;
        head.next.next = newNode(3);
        head.next.next.prev = head.next;
        head.next.next.next = newNode(2);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = newNode(4);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = newNode(2);
        head.next.next.next.next.next.prev = head.next.next.next.next;
        head.next.next.next.next.next.next = newNode(5);
        head.next.next.next.next.next.next.prev = head.next.next.next.next.next;

        // Print original list
        System.out.print("Original list: ");
        printList(head);

        // Delete all occurrences of 2
        deleteAllOccurrences sol = new deleteAllOccurrences();
        head = sol.deleteAllOccurrences(head, 2);

        // Print modified list
        System.out.print("Modified list: ");
        printList(head);
    }

}


