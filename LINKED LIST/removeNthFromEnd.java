import java.util.List;
import java.util.ArrayList;
import java.util.*;

// Definition of Single Linked List
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

class removeNthFromEnd {
    // Function to remove the nth node from the end
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Creating pointers
        ListNode fastp = head;
        ListNode slowp = head;

        // Move the fastp pointer N nodes ahead
        for (int i = 0; i < n; i++) {
            if (fastp == null) return head;
            fastp = fastp.next;
        }

        // If fastp becomes NULL, the Nth node from the end is the head
        if (fastp == null) {
            return head.next;
        }

        // Move both pointers until fastp reaches the end
        while (fastp.next != null) {
            fastp = fastp.next;
            slowp = slowp.next;
        }

        // Delete the Nth node from the end
        slowp.next = slowp.next.next;
        return head;
    }

    // Function to print the linked list
    public static void printLL(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        int N = 3;

        // Creation of linked list
        ListNode head = new ListNode(arr.get(0));
        ListNode current = head;
        for (int i = 1; i < arr.size(); i++) {
            current.next = new ListNode(arr.get(i));
            current = current.next;
        }

        // removeNthFromEnd instance
        head = removeNthFromEnd(head, N);
        printLL(head);
    }
}
