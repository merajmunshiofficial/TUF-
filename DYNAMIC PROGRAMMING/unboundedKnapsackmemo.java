import java.util.*;

class unboundedKnapsackmemo {
    // Function to solve the unbounded knapsack problem
    private int func(int[] wt, int[] val, int ind, int W, int[][] dp) {
        // Base case: if we're at the first item
        if (ind == 0) {
            /* Calculate and return the maximum
            value for the given weight limit*/
            return (W / wt[0]) * val[0];
        }
    
        /* If the result for this index and weight
        limit is already calculated, return it*/
        if (dp[ind][W] != -1)
            return dp[ind][W];
        
        /* Calculate the maximum value 
        without taking the current item*/
        int notTaken = func(wt, val, ind - 1, W, dp);
    
        /* Calculate the maximum value
        by taking the current item*/
        int taken = Integer.MIN_VALUE;
        if (wt[ind] <= W)
            taken = val[ind] + func(wt, val, ind, W - wt[ind], dp);
        
        /* Store the maximum value in
        the DP table and return it*/
        return dp[ind][W] = Math.max(notTaken, taken);
    }
    
    // Function to solve the unbounded knapsack problem
    public int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n][W + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
    
        /* Call the utility function
        to calculate the maximum value*/
        return func(wt, val, n - 1, W, dp);
    }

    public static void main(String[] args) {
        int[] wt = {2, 4, 6};
        int[] val = {5, 11, 13};
        int W = 10;
        int n = wt.length;
        
        // Create an instance of unboundedKnapsackmemo class
        unboundedKnapsackmemo sol = new unboundedKnapsackmemo();
        
        System.out.println("The Maximum value of items the thief can steal is " + sol.unboundedKnapsack(wt, val, n, W));
    }
}
