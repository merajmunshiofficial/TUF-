import java.util.*;

class stockBuySelliimemo {
    // Function to find the maximum profit earned using memoization
    private int func(int ind, int buy, int n, int[] arr, int[][] dp) {
        // Base case 
        if (ind == n) {
            return 0;
        }
        /* If the result for this state has 
        already been calculated, return it*/
        if (dp[ind][buy] != -1) {
            return dp[ind][buy];
        }
        int profit = 0;
        
        // We can buy the stock
        if (buy == 0) { 
            profit = Math.max(0 + func(ind + 1, 0, n, arr, dp), (-1)*arr[ind] + func(ind + 1, 1, n, arr, dp));
        }
        
        // We can sell the stock
        if (buy == 1) { 
            profit = Math.max(0 + func(ind + 1, 1, n, arr, dp), arr[ind] + func(ind + 1, 0, n, arr, dp));
        }

        /* Store the value in dp array and
        return the calculated profit */
        return dp[ind][buy] = profit;
    }

    // Function to calculate the maximum profit earned 
    public int stockBuySell(int[] arr, int n) {
        if (n == 0) 
            return 0;
            
        // Initialize a DP table to memoize results
        int[][] dp = new int[n][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = func(0, 0, n, arr, dp);
        
        // Return the maximum profit
        return ans;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] arr = {7, 1, 5, 3, 6, 4};
        
        // Create an instance of stockBuySelliimemo class
        stockBuySelliimemo sol = new stockBuySelliimemo();

        // Call the stockBuySell function and print the result
        System.out.println("The maximum profit that can be generated is " + sol.stockBuySell(arr, n));
    }
}
