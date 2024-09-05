package HEAPS;

/*
    Time Complexity: O(N * logK)
    Space Complexity: O(K)

    Where 'N' is the total number of Nodes.
    And 'K' is the number of lists.
*/

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.LinkedList;


public class mergeKLists {

    public static LinkedListNode<Integer> mergeKLists(LinkedListNode<Integer>[] listArray) {
        int k = listArray.length;

        if (k == 0) {
            return null;
        }

        PriorityQueue<LinkedListNode<Integer>> helperPQ = new PriorityQueue(new LLComparator());

		// Add nodes in the queue.
        for (int i = 0; i < k; i++) {
            if (listArray[i] != null) {
                helperPQ.add(listArray[i]);
            }
        }

        LinkedListNode<Integer> head = null, tail = null;

		// Add nodes while queue is non empty.
        while (helperPQ.size() > 0) {
            LinkedListNode<Integer> minNode = helperPQ.poll();

            if (minNode.next != null) {
                helperPQ.add(minNode.next);
                minNode.next = null;
            }

            if (head == null) {
                head = minNode;
                tail = minNode;
            }
            else {
                tail.next = minNode;
                tail = tail.next;
            }
        }

        return head;
    }

}

// Compare function for priority queue.
class LLComparator implements Comparator<LinkedListNode<Integer>>{ 
               
    public int compare(LinkedListNode<Integer> s1, LinkedListNode<Integer> s2) {
        int a = s1.data, b = s2.data;  
        if (a > b) {
            return 1; 
        }
        else if (a < b) {
            return -1;  
        }
        return 0;
    } 
} 