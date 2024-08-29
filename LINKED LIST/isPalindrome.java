import java.util.*;

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


class isPalindrome {
    /*Function to reverse a linked list
    using the recursive approach*/
    private ListNode reverseLinkedList(ListNode head) {
        /* Check if the list is empty
        or has only one node */
        if (head == null || head.next == null) {
            /* No change is needed;
            return the current head */
            return head;
        }

        /* Reverse the remaining
        part of the list and get the new head */
        ListNode newHead = reverseLinkedList(head.next);

        /* Store the next node in 'front'
        to reverse the link */
        ListNode front = head.next;

        /* Update the 'next' pointer of 'front' to
        point to the current head, effectively
        reversing the link direction */
        front.next = head;

        /* Set the 'next' pointer of the
        current head to 'null' to
        break the original link */
        head.next = null;

        /* Return the new head obtained
        from the recursion */
        return newHead;
    }

    public boolean isPalindrome(ListNode head) {
        /* Check if the linked list is empty
        or has only one node */
        if (head == null || head.next == null) {
            // It's a palindrome by definition
            return true;
        }

        /* Initialize two pointers, slow and fast,
        to find the middle of the linked list */
        ListNode slow = head;
        ListNode fast = head;

        /* Traverse the linked list to find the
        middle using slow and fast pointers */
        while (fast.next != null && fast.next.next != null) {
            // Move slow pointer one step
            slow = slow.next;
            // Move fast pointer two steps
            fast = fast.next.next;
        }

        /* Reverse the second half of the
        linked list starting from the middle */
        ListNode newHead = reverseLinkedList(slow.next);

        // Pointer to the first half
        ListNode first = head;
        // Pointer to the reversed second half
        ListNode second = newHead;
        while (second != null) {
            /* Compare data values of
            nodes from both halves.
            If values do not match,
            the list is not a palindrome */
            if (first.val != second.val) {
                /* Reverse the second half
                back to its original state */
                reverseLinkedList(newHead);
                // Not a palindrome
                return false;
            }

            // Move the first pointer
            first = first.next;
            // Move the second pointer
            second = second.next;
        }

        /* Reverse the second half
        back to its original state */
        reverseLinkedList(newHead);

        // Linked List is a palindrome
        return true;
    }

    /*Function to print the linked list*/
    public static void printLinkedList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /* Create a linked list with values 1, 5, 2, 5, and 1 (15251, a palindrome) */
        ListNode head = new ListNode(1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(1);

        // Print the original linked list
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Check if the linked list is a palindrome
        isPalindrome isPalindrome = new isPalindrome();
        if (isPalindrome.isPalindrome(head)) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}
