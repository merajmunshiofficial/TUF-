import java.util.*;

class countmemo {
    /* Function to count the number of ways 
    to make change for a given target sum*/
    private int func(int[] arr, int ind, int T, int[][] dp) {
        // Base case: if we're at the first element
        if (ind == 0) {
            /* Check if the target sum is 
            divisible by the first element*/
            return (T % arr[0] == 0) ? 1 : 0;
        }

        /* If the result for this index and target 
        sum is already calculated, return it*/
        if (dp[ind][T] != -1)
            return dp[ind][T];

        /* Calculate the number of ways 
        without taking the current element*/
        int notTaken = func(arr, ind - 1, T, dp);

        /* Calculate the number of ways
        by taking the current element*/
        int taken = 0;
        if (arr[ind] <= T)
            taken = func(arr, ind, T - arr[ind], dp);

        /* Store the sum of ways in 
        the DP table and return it*/
        return dp[ind][T] = notTaken + taken;
    }

    /* Function to count the number of 
    ways to make change for the target sum*/
    public int count(int[] coins, int N, int amount) {
        int[][] dp = new int[N][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Call the utility function to calculate answer
        return func(coins, N - 1, amount, dp);
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int amount = 4;
        int N = coins.length;

        // Create an instance of countmemo class
        countmemo sol = new countmemo();

        // Print the result
        System.out.println("The total number of ways is " + sol.count(coins, N, amount));
    }
}

