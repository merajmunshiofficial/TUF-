package RECURSION;

import java.util.*;

public class combinationSum2 {
    // Helper function to find combinations
    public void func(int[] v, int i, int sum, List<Integer> v2, List<List<Integer>> ans) {
        // If the sum is 0, we found a valid combination
        if (sum == 0) {
            // Add the current combination to the answer list
            ans.add(new ArrayList<>(v2));
            return;
        }
        // If sum becomes negative or index goes out of bounds, return
        if (sum < 0 || i >= v.length) {
            return;
        }

        // Loop through the array starting from index i
        for (int j = i; j < v.length; j++) {
            // Skip duplicates to avoid redundant combinations
            if (j > i && v[j] == v[j - 1]) {
                continue;
            }
            // Add current number to the combination
            v2.add(v[j]);
            // Recur with the next index and updated sum
            func(v, j + 1, sum - v[j], v2, ans);
            // Remove the last number added to backtrack
            v2.remove(v2.size() - 1);
        }
    }

    // Main function to get all unique combinations
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> v = new ArrayList<>();
        // Sort the array to handle duplicates easily
        Arrays.sort(candidates);
        // Call the helper function to start finding combinations
        func(candidates, 0, target, v, ans);
        return ans;
    }

    // Main method to run the code
    public static void main(String[] args) {
        combinationSum2 sol = new combinationSum2();
        // Example input
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        // Get the combinations
        List<List<Integer>> result = sol.combinationSum2(candidates, target);
        // Print the result
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}
