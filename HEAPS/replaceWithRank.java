package HEAPS;

/*
    Time complexity: O(N * Log(N))
    Space complexity: O(N)

    Where 'N' is the size of given array.
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class replaceWithRank
{
    public static List<Integer> replaceWithRank(List<Integer> arr, int n)
    {
        // Make copy of array and sort it in non-decreasing order.
        List<Integer> temp = new ArrayList<>();
        for(int i=0 ; i<arr.size() ; i++)
        {
            temp.add(arr.get(i));
        }
        Collections.sort(temp);

        // Consist mapping of each element with its rank.
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int rank = 1;

        // Find Rank of each element.
        for(int i = 0; i < n; i++)
        {
            if(!hashMap.containsKey(temp.get(i)))
            {
                hashMap.put(temp.get(i), rank);
                rank++;
            }
        }

        // Replace each element with its corresponding rank.
        for(int i = 0; i < n; i++)
        {
            arr.set(i, hashMap.get(arr.get(i)));
        }

        return arr;
    }
}
