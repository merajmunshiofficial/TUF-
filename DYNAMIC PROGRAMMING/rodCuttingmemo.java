import java.util.*;

class rodCuttingmemo {
    /* Function to solve the rod 
    cutting problem using memoization*/
    private int func(int ind, int n, int[] price, int[][] dp) {
        /* Base case: If there is only one
        rod piece, its value is price[0] * n*/
        if (ind == 0) {
            return price[0] * n;
        }

        /* If the result for this state is
        already calculated, return it*/
        if (dp[ind][n] != -1) {
            return dp[ind][n];
        }

        /* Calculate the maximum value by
        not taking the current rod piece*/
        int notTaken = func(ind - 1, n, price, dp);

        /* Calculate the length of the rod
        corresponding to the current index*/
        int rodLength = ind + 1;

        /* Initialize the value for taking 
        the current rod piece as very small*/
        int taken = Integer.MIN_VALUE;
        
        /* If the rod length is less than or equal
        to the remaining length, consider taking it*/
        if (rodLength <= n) {
            taken = price[ind] + func(ind, n - rodLength, price, dp);
        }

        /* Store the maximum value in 
        the DP table and return it*/
        dp[ind][n] = Math.max(notTaken, taken);
        return dp[ind][n];
    }

    /* Function to initialize the DP table
    and start the rod cutting process*/
    public int rodCutting(int[] price, int n) {
        /* Initialize DP table with 
        -1 (indicating uncalculated states)*/
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        /* Call the utility function 
        to calculate the maximum value*/
        return func(n - 1, n, price, dp);
    }
    public static void main(String[] args) {
        int[] price = {2, 4, 6, 8};
        int n = price.length;

        // Create an instance of rodCuttingmemo class
        rodCuttingmemo sol = new rodCuttingmemo();

        // Print the result
        System.out.println("The Maximum value is " + sol.rodCutting(price, n));
    }
}


