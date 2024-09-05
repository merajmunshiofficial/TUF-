import java.util.*;

class minimumCoinstabu {
    /* Function to find the minimum number 
    of elements needed to form the target sum */
    public int minimumCoins(int[] coins, int amount) {
        int n = coins.length;

        /* Create a 2D DP table with
        n rows and amount+1 columns */
        int[][] dp = new int[n][amount + 1];

        // Initialize the first row of the DP table
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = i / coins[0];
            else
                dp[0][i] = (int)1e9;
        }

        // Fill the DP table using a bottom-up approach
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= amount; target++) {
                /* Calculate the minimum elements needed
                without taking the current element */
                int notTake = dp[ind - 1][target];

                /* Calculate the minimum elements 
                needed by taking the current element */
                int take = (int)1e9;
                if (coins[ind] <= target)
                    take = 1 + dp[ind][target - coins[ind]];

                /* Store the minimum of 'notTake'
                and 'take' in the DP table */
                dp[ind][target] = Math.min(notTake, take);
            }
        }

        // The answer is in the bottom-right cell 
        int ans = dp[n - 1][amount];

        /* If 'ans' is still very large, it means 
        it's not possible to form the target sum */
        if (ans >= (int)1e9)
            return -1;

        // Return the minimum number of coins needed
        return ans;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int amount = 7;

        // Create an instance of minimumCoinstabu class
        minimumCoinstabu sol = new minimumCoinstabu();

        // Call the function to find the minimum coins
        int result = sol.minimumCoins(coins, amount);

        // Output the result
        System.out.println("The minimum number of coins required to form the target sum is " + result);
    }
}
