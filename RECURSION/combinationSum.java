package RECURSION;

import java.util.ArrayList;
import java.util.List;

class combinationSum {

    // Recursive function to find all subsequences with the given target sum
    public void func(List<Integer> v, int i, int sum, List<Integer> v2, List<List<Integer>> ans) {
        // Base case: if the sum is zero, add the current subsequence to the result
        if (sum == 0) {
            ans.add(new ArrayList<>(v2));
            return;
        }
        
        // Base case: if the sum becomes negative or no elements are left
        if (sum < 0 || i < 0) {
            return;
        }

        // Exclude the current element and move to the next
        func(v, i - 1, sum, v2, ans);
        
        // Include the current element in the subsequence
        v2.add(v.get(i));
        
        // Recursively call the function with the included element
        func(v, i, sum - v.get(i), v2, ans);
        
        // Backtrack by removing the last added element
        v2.remove(v2.size() - 1);
    }

    // Main function to find all unique combinations of candidates that sum to the target
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> v = new ArrayList<>();
        
        // Convert the array to a list for easier manipulation
        for (int num : candidates) {
            v.add(num);
        }
        
        // Start the recursive process
        func(v, v.size() - 1, target, new ArrayList<>(), ans);
        
        return ans;
    }

    // Main method to test the combinationSum
    public static void main(String[] args) {
        combinationSum sol = new combinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = sol.combinationSum(candidates, target);
        System.out.println(result);
    }
}
