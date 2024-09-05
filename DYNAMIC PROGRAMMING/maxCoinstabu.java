import java.util.*;

class maxCoinstabu {
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
        
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j) continue;
                int maxi = Integer.MIN_VALUE;

                /* Iterate through each possible
                balloon to burst last*/
                for (int ind = i; ind <= j; ind++) {
                    
                    /* Calculate the coins obtained by 
                    bursting the ind-th balloon last*/
                    int coins = newNums[i - 1] * newNums[ind] * newNums[j + 1];

                    /* Calculate the maximum coins
                    for the remaining balloons*/
                    int remainingCoins = dp[i][ind - 1] + dp[ind + 1][j];

                    // Update the maximum coins
                    maxi = Math.max(maxi, coins + remainingCoins);
                }
                // Store the maximum value in dp table
                dp[i][j] = maxi;
            }
        }
        // Return the result
        return dp[1][n];
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};

        // Create an instance of maxCoinstabu class
        maxCoinstabu sol = new maxCoinstabu();

        // Print the result
        System.out.println("Maximum coins obtained: " + sol.maxCoins(nums));
    }
}
