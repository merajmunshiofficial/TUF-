import java.util.*;

// Definition of singly linked list
class ListNode {
    int val;
    ListNode next;

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}

class MergeTwoLists {
    // Function to merge two sorted linked lists
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to serve as the head of the merged list
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        // Traverse both lists simultaneously
        while (list1 != null && list2 != null) {
            // Compare elements of both lists and link the smaller node to the merged list
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

        // If any list still has remaining elements, append them to the merged list
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        // Return merged list 
        return dummyNode.next;
    }

     // Function to print the linked list
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
        // Example Linked Lists
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        System.out.print("First sorted linked list: ");
        printLinkedList(list1);

        System.out.print("Second sorted linked list: ");
        printLinkedList(list2);

        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode mergedList = mergeTwoLists.mergeTwoLists(list1, list2);

        System.out.print("Merged sorted linked list: ");
        printLinkedList(mergedList);
    }


}

