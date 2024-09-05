import java.util.*;

class maxCoinsmemo {
    /* Recursive function to calculate
    the maximum coins obtained*/
    private int func(int i, int j, int[] nums, int[][] dp) {
        if (i > j) return 0;
        
        // Check if the subproblem is already solved
        if (dp[i][j] != -1) return dp[i][j];
        
        int maxCoins = Integer.MIN_VALUE;

        // Iterate through each balloon to burst last
        for (int k = i; k <= j; k++) {
            /* Calculate the coins obtained
            by bursting the k-th balloon last*/
            int coins = nums[i - 1] * nums[k] * nums[j + 1];
            
            /* Recursively calculate the maximum 
            coins for the remaining balloons*/
            int remainingCoins = func(i, k - 1, nums, dp) + func(k + 1, j, nums, dp);
            
            // Update the maximum coins
            maxCoins = Math.max(maxCoins, coins + remainingCoins);
        }
        // Return the result
        return dp[i][j] = maxCoins;
    }

    // Function to calculate the maximum coins obtained
    public int maxCoins(int[] nums) {
        int n = nums.length;

        // Add 1 to the beginning and end of nums array
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        System.arraycopy(nums, 0, newNums, 1, n);

        // Create a DP array for memoization
        int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Call helper function to compute maximum coins
        return func(1, n, newNums, dp);
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};

        // Create an instance of maxCoinsmemo class
        maxCoinsmemo sol = new maxCoinsmemo();

        System.out.println("Maximum coins obtained: " + sol.maxCoins(nums));
    }
}
