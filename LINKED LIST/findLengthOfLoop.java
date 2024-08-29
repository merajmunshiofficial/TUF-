import java.util.*;

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

class findLengthOfLoop {
    // Function to find the length of the loop
    int findLength(ListNode slow, ListNode fast) {
        // Count to keep track of nodes encountered in loop
        int cnt = 1;
        
        // Move fast by one step
        fast = fast.next;
        
        // Traverse fast till it reaches back to slow
        while (slow != fast) {
            /* At each node 
            increase count by 1
            move fast forward 
            by one step */
            cnt++;
            fast = fast.next;
        }
        
        /* Loop terminates 
        when fast reaches slow again 
        and the count is returned*/
        return cnt;
    }

    // Function to find the length of the loop
    public int findLengthOfLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list to detect a loop
        while (fast != null && fast.next != null) {
            // Move slow one step
            slow = slow.next;
            // Move fast two steps
            fast = fast.next.next;

            // If the slow and fast pointers meet
            // there is a loop
            if (slow == fast) {
                // return the number of nodes 
                return findLength(slow, fast);
            }
        }

        /* If the fast pointer 
        reaches the end, 
        there is no loop */
        return 0;
    }

    public static void main(String[] args) {
        // Create a sample linked list with a loop
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        // Create a loop from fifth to second
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = second;

        findLengthOfLoop findLengthOfLoop = new findLengthOfLoop();
        int loopLength = findLengthOfLoop.findLengthOfLoop(head);
        if (loopLength > 0) {
            System.out.println("Length of the loop: " + loopLength);
        } else {
            System.out.println("No loop found in the linked list.");
        }
    }
}
