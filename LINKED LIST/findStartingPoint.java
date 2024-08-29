//Definition of singly linked list:
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


class findStartingPoint {
    public ListNode findStartingPoint(ListNode head) {
        // Initialize a slow and fast 
        // pointers to the head of the list
        ListNode slow = head;
        ListNode fast = head;

        // Phase 1: Detect the loop
        while (fast != null && fast.next != null) {
            
            // Move slow one step
            slow = slow.next;
            
            // Move fast two steps
            fast = fast.next.next;

            // If slow and fast meet,
            // a loop is detected
            if (slow == fast) {
                
                // Reset the slow pointer
                // to the head of the list
                slow = head;

                // Phase 2: Find the first node of the loop
                while (slow != fast) {
                    
                    // Move slow and fast one step
                    // at a time
                    slow = slow.next;
                    fast = fast.next;

                    // When slow and fast meet again,
                    // it's the first node of the loop
                }
                
                // Return the first node of the loop
                return slow;
            }
        }
        
        // If no loop is found, return null
        return null;
    }

    public static void main(String[] args) {
        // Create a sample linked list with a loop
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;

        // Make a loop from node5 to node2
        node5.next = node2;

        // Set the head of the linked list
        ListNode head = node1;

        // Detect the loop in the linked list
        findStartingPoint sol = new findStartingPoint();
        ListNode loopStartNode = sol.findStartingPoint(head);

        if (loopStartNode != null) {
            System.out.println("Loop detected. Starting node of the loop is: " + loopStartNode.val);
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }


}

