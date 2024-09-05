import java.util.*;

class minimumCoinsmemo {
    final int mod = (int)1e9 + 7;

    /* Function to calculate the minimum number
    of elements to form the target sum */
    private int func(int[] arr, int ind, int T, int[][] dp) {
        // Base case: If we're at the first element
        if (ind == 0) {
            /* Check if the target sum is
            divisible by the first element */
            if (T % arr[0] == 0)
                return T / arr[0];
            else
                /* Otherwise, return a very large
                value to indicate it's not possible */
                return (int)1e9;
        }

        /* If the result for this index and target
        sum is already calculated, return it */
        if (dp[ind][T] != -1)
            return dp[ind][T];

        /* Calculate the minimum elements needed
        without taking the current element */
        int notTaken = func(arr, ind - 1, T, dp);

        /* Calculate the minimum elements
        needed by taking the current element */
        int taken = (int)1e9;
        if (arr[ind] <= T)
            taken = 1 + func(arr, ind, T - arr[ind], dp);

        /* Store the minimum of 'notTaken' and
        'taken' in the DP array and return it */
        return dp[ind][T] = Math.min(notTaken, taken);
    }

    /* Function to find the minimum number
    of coins needed to form the target sum */
    public int minimumCoins(int[] coins, int amount) {
        int n = coins.length;

        /* Create a DP (Dynamic Programming) table with
        n rows and amount+1 columns and initialize it with -1 */
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        // Call utility function to calculate the answer
        int ans = func(coins, n - 1, amount, dp);

        /* If 'ans' is still very large, it means
        it's not possible to form the target sum */
        if (ans >= (int)1e9)
            return -1;

        // Return the minimum number of coins
        return ans;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int amount = 7;

        // Create an instance of minimumCoinsmemo class
        minimumCoinsmemo sol = new minimumCoinsmemo();

        // Print the result
        System.out.println("The total number of ways is " + sol.minimumCoins(coins, amount));
    }
}
