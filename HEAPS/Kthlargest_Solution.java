package HEAPS;

/*
      Time Complexity : O(Nlog(K))
      Space Complexity : O(N),

      where N is the maximum number of integers read at runtime and K is the required order of number in sorted order
*/
import java.util.PriorityQueue;

public class Kthlargest_Solution {
    public static class Kthlargest {

        // Initialise priority queue and 'size'.
        int size;
        PriorityQueue<Integer> pq;

        Kthlargest(int k, int []arr) {
            this.size = k;
            this.pq = new PriorityQueue<>();
            for (int it : arr) {
                pq.offer(it);
                if (pq.size() > size) {
                    pq.poll();
                }
            }
        }

        int add(int num) {
            // Push the current 'num' in priority queue.
            pq.add(num);

            // Maintain only 'k' elelments in priority queue.
            if (pq.size() > size) {
                pq.poll();
            }

            // Return the top element.
            return pq.peek();
        }
    };
}