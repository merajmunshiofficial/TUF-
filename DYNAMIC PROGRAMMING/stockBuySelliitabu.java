import java.util.*;

class stockBuySelliitabu {
    // Function to find maximum profit earned using tabulation
    private int func(int[] arr, int n) {
        // Create a DP table to memoize results
        int[][] dp = new int[n + 1][2];

        // Base condition
        dp[n][0] = dp[n][1] = 0;

        int profit = 0;

        // Loop through the array in reverse order
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                // We can buy the stock
                if (buy == 0) { 
                    profit = Math.max(0 + dp[ind + 1][0], (-1)*arr[ind] + dp[ind + 1][1]);
                }
            
                // We can sell the stock
                if (buy == 1) { 
                    profit = Math.max(0 + dp[ind + 1][1], arr[ind] + dp[ind + 1][0]);
                }

                dp[ind][buy] = profit;
            }
        }

        /* The maximum profit is stored in
        dp[0][0] after all calculations*/
        return dp[0][0];
    }

    // Function to calculate the maximum profit earned
    public int stockBuySell(int[] arr, int n){
        // Return the maximum profit
        return func(arr, n);
    }

    public static void main(String[] args) {
        int n = 6;
        int[] arr = {7, 1, 5, 3, 6, 4};
        
        // Create an instance of stockBuySelliitabu class
        stockBuySelliitabu sol = new stockBuySelliitabu();

        // Call the stockBuySell function and print the result
        System.out.println("The maximum profit that can be generated is " + sol.stockBuySell(arr, n));
    }
}
