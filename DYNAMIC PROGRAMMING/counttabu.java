import java.util.*;

class counttabu {
    /* Function to count the number of 
    ways to make change for the target sum*/
    public int count(int[] coins, int N, int amount) {
        int[][] dp = new int[N][amount + 1];

        // Initializing base condition
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = 1;
            // Else condition is automatically fulfilled,
            // as dp array is initialized to zero
        }

        for (int ind = 1; ind < N; ind++) {
            for (int target = 0; target <= amount; target++) {
                int notTaken = dp[ind - 1][target];

                int taken = 0;
                if (coins[ind] <= target)
                    taken = dp[ind][target - coins[ind]];

                dp[ind][target] = notTaken + taken;
            }
        }
        // Return the result
        return dp[N - 1][amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int amount = 4;
        int N = coins.length;

        // Create an instance of counttabu class
        counttabu sol = new counttabu();

        // Print the result
        System.out.println("The total number of ways is " + sol.count(coins, N, amount));
    }
}


