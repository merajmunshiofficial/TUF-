import java.util.*;

class stockBuySellvmemo {
    // Function to find the maximum profit earned using memoization
    private int func(int ind, int buy, int fee, int n, int[] arr, int[][] dp) {
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
            profit = Math.max(0 + func(ind + 1, 0, fee, n, arr, dp), (-1)*arr[ind] + func(ind + 1, 1, fee, n, arr, dp));
        }
        
        // We can sell the stock
        if (buy == 1) { 
            profit = Math.max(0 + func(ind + 1, 1, fee, n, arr, dp), arr[ind]-fee + func(ind + 1, 0, fee, n, arr, dp));
        }

        /* Store the value in dp array and
        return the calculated profit */
        return dp[ind][buy] = profit;
    }

    // Function to calculate the maximum profit earned 
    public int stockBuySell(int[] arr, int n, int fee) {
        if (n == 0) 
            return 0;
            
        // Declare a DP table to memoize results
        int[][] dp = new int[n][2];
        
        // Initialize the dp array with -1
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = func(0, 0, fee, n, arr, dp);
        
        // Return the maximum profit
        return ans;
    }

    public static void main(String[] args) {
        int n = 8;
        int[] arr = {3, 3, 5, 0, 0, 3, 1, 4};
        int fee = 1;
        
        // Create an instance of stockBuySellvmemo class
        stockBuySellvmemo sol = new stockBuySellvmemo();

        // Call the stockBuySell function and print the result
        System.out.println("The maximum profit that can be generated is " + sol.stockBuySell(arr, n, fee));
    }
}
