package HEAPS;

/*
    Time Complexity: O(N)
    Space Complexity: O(N)

    where 'N' is the size of the input array.
*/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class kmostfrequentele {

	public static int[] KMostFrequent(int n, int k, int[] arr) {

		Map<Integer, Integer> map = new HashMap<>();

		// Build map where the key is element
		// and value is how often this element appears in 'ARR'.
		for (int ele : arr) {

			map.put(ele, map.getOrDefault(ele, 0) + 1);
		}

		List<Integer>[] bucket = new List[n + 1];

		for (int key : map.keySet()) {

            int freq = map.get(key);

            if (bucket[freq] == null) {

                bucket[freq] = new LinkedList<>();
			}

            // Add in correct bucket.
			bucket[freq].add(key);
		}

		int[] ans = new int[k];
        int cur = 0;

        // Add 'K' elements to answer array starting from the rightmost bucket.
        for (int i = bucket.length - 1; i > 0 && k > 0; i--) {

            if (bucket[i] == null) {
                continue;
            }

            for (int num : bucket[i]) {

                ans[cur++] = num;
                k--;
            }
        }

        return ans;
    }
}
