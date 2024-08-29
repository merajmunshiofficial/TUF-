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

class getIntersectionNode {
    // Function to find the intersection node of two linked lists
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Initialize two pointers, d1 and d2
        ListNode d1 = headA;
        ListNode d2 = headB;

        // Traverse both lists until the pointers meet
        while (d1 != d2) {
            // Move pointer d1 to the head of the second list if it reaches the end of the first list
            d1 = (d1 == null) ? headB : d1.next;
            // Move pointer d2 to the head of the first list if it reaches the end of the second list
            d2 = (d2 == null) ? headA : d2.next;
        }

        // Return the intersection node
        return d1;
    }

    // Utility function to insert a node at the end of the linked list
    public static void insertNode(ListNode head, int val) {
        // Create a new node with the given value
        ListNode newNode = new ListNode(val);
        // If the list is empty, set the new node as the head
        if (head == null) {
            head = newNode;
            return;
        }
        // Otherwise, traverse to the end of the list
        ListNode temp = head;
        while (temp.next != null) temp = temp.next;
        // Insert the new node at the end of the list
        temp.next = newNode;
    }

    // Utility function to print the linked list
    public static void printList(ListNode head) {
        // Traverse the list
        while (head.next != null) {
            // Print the value of each node followed by an arrow
            System.out.print(head.val + "->");
            head = head.next;
        }
        // Print the value of the last node
        System.out.println(head.val);
    }

    public static void main(String[] args) {
        // Creation of the first list
        ListNode head1 = new ListNode(1);
        insertNode(head1, 3);
        insertNode(head1, 1);
        insertNode(head1, 2);
        insertNode(head1, 4);

        // Create an intersection
        ListNode intersection = head1.next.next.next;

        // Creation of the second list
        ListNode head2 = new ListNode(3);
        head2.next = intersection;

        // Printing the lists
        System.out.print("List1: ");
        printList(head1);
        System.out.print("List2: ");
        printList(head2);

        // Checking if an intersection is present
        getIntersectionNode sol = new getIntersectionNode();
        ListNode answerNode = sol.getIntersectionNode(head1, head2);
        if (answerNode == null)
            System.out.println("No intersection");
        else
            System.out.println("The intersection point is " + answerNode.val);
    }
}
