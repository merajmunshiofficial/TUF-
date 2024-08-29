import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class mergeTwoSortedLinkedLists {
    // Function to merge two sorted linked lists
    public ListNode mergeTwoSortedLinkedLists(ListNode list1, ListNode list2) {
        // Create dummy node to serve as head of merged list
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        // Traverse both lists simultaneously
        while (list1 != null && list2 != null) {
            /*Compare elements of both lists 
            and link the smaller node 
            to the merged list*/
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            // Move the temporary pointer to the next node
            temp = temp.next; 
        }

        /*If any list still has 
        remaining elements append 
        them to the merged list*/
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }
        // Return the merged list starting 
        // from the next of the dummy node
        return dummyNode.next;
    }

    // Function to find the middle of a linked list
    public ListNode findMiddle(ListNode head) {
        // If the list is empty or has only one node, 
        // the middle is the head itself
        if (head == null || head.next == null) {
            return head;
        }

        // Initializing slow and fast pointers
        ListNode slow = head;
        ListNode fast = head.next;

       /* Move the fast pointer twice as fast as the slow pointer
        When the fast pointer reaches the end, the slow pointer 
        will be at the middle*/
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Function to perform merge sort on a linked list
    public ListNode sortList(ListNode head) {
        /*Base case: if the list is empty or has only one node, 
        it is already sorted, so return the head*/
        if (head == null || head.next == null) {
            return head;
        }
        
        // Find middle of list using findMiddle function
        ListNode middle = findMiddle(head);
        
        // Divide the list into two halves
        ListNode right = middle.next;
        middle.next = null;
        ListNode left = head;
        
        // Recursively sort left and right halves
        left = sortList(left);
        right = sortList(right);
        
        // Merge the sorted halves using the 
        // mergeTwoSortedLinkedLists function
        return mergeTwoSortedLinkedLists(left, right);
    }

    public static void printLinkedList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            // Print the data of the current node
            System.out.print(temp.val + " "); 
            // Move to the next node
            temp = temp.next; 
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Linked List: 3 2 5 4 1
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(1);

        System.out.print("Original Linked List: ");
        printLinkedList(head);

        mergeTwoSortedLinkedLists mergeTwoSortedLinkedLists = new mergeTwoSortedLinkedLists();
        // Sort the linked list
        head = mergeTwoSortedLinkedLists.sortList(head);

        System.out.print("Sorted Linked List: ");
        printLinkedList(head);
    }

    
}

  

