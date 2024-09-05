import java.util.*;

class targetSumtabu {
    private static final int MOD = (int)1e9 + 7;

    /* Function to count partitions of the 
    array into subsets with a given target sum */
    private int func(int[] arr, int target) {
        int n = arr.length;
        int[][] dp = new int[n][target + 1];

        if (arr[0] == 0) 
            // 2 cases - pick and not pick
            dp[0][0] = 2;   
        else
            // 1 case - not pick
            dp[0][0] = 1;  

        if (arr[0] != 0 && arr[0] <= target)
            // 1 case - pick
            dp[0][arr[0]] = 1;  

        for (int ind = 1; ind < n; ind++) {
            for (int tar = 0; tar <= target; tar++) {
                int notTaken = dp[ind - 1][tar];

                int taken = 0;
                if (arr[ind] <= tar)
                    taken = dp[ind - 1][tar - arr[ind]];

                dp[ind][tar] = (notTaken + taken) % MOD;
            }
        }
        return dp[n - 1][target];
    }

    /* Function to count the number 
    of ways to achieve the target sum */
    public int targetSum(int n, int target, int[] nums) {
        int totSum = 0;
        for (int num : nums) {
            totSum += num;
        }

        // Checking for edge cases
        if (totSum - target < 0 || (totSum - target) % 2 != 0)
            // Not possible to achieve target sum
            return 0;  

        return func(nums, (totSum - target) / 2);
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int target = 3;
        int n = nums.length; 
        
        // Create an instance of targetSumtabu class
        targetSumtabu sol = new targetSumtabu();

        // Print the result
        System.out.println("The total number of ways is " + sol.targetSum(n, target, nums));
    }
}


