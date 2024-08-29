package RECURSION;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class countSubsequenceWithTargetSum {
    // Helper function to count subsequences
    // with the target sum
    private int func(int ind, int sum, int[] nums) {
        // Base case: if sum is 0, one valid
        // subsequence is found
        if (sum == 0) return 1;
        // Base case: if sum is negative or 
        // index exceeds array size
        if (sum < 0 || ind == nums.length) return 0;
        // Recurse by including current number
        // or excluding it from the sum
        return func(ind + 1, sum - nums[ind], nums) + func(ind + 1, sum, nums);
    }

    // Function to start counting subsequences
    public int countSubsequenceWithTargetSum(int[] nums, int target) {
        return func(0, target, nums);
    }

    // Main function to test the countSubsequenceWithTargetSum
    public static void main(String[] args) {
        countSubsequenceWithTargetSum sol = new countSubsequenceWithTargetSum();
        int[] nums1 = {1, 2, 3, 4};
        int target = 5;
        System.out.println("Number of subsequences with target sum " + target + ": "
                + sol.countSubsequenceWithTargetSum(nums1, target));
    }
}
