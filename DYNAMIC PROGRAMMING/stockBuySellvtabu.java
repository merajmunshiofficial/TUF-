import java.util.*;

class stockBuySellvtabu {
    // Function to find the maximum profit using tabulation
    private int func(int[] arr, int n, int fee) {
        /* Declaring a 2D DP array of 
        size [n+1][2] initialized to 0*/
        int[][] dp = new int[n + 1][2];

        /* Base case: dp array is already i
        nitialized to 0, covering the base case.*/

        // Iterate backwards through the prices array
        for (int ind = n - 1; ind >= 0; ind--) {
            
            // buy can be 0 (buying) or 1 (selling)
            for (int buy = 0; buy <= 1; buy++) {
                
                int profit = 0;
                // We can buy the stock
                if (buy == 0) { 
                    profit = Math.max(0 + dp[ind + 1][0],(-1)*arr[ind] + dp[ind + 1][1]);
                }
                // We can sell the stock
                if (buy == 1) { 
                    profit = Math.max(0 + dp[ind + 1][1],arr[ind]-fee + dp[ind + 1][0]);
                }
                dp[ind][buy] = profit;
            }
        }

        /* The result is stored in dp[0][0] which represents 
        maximum profit after the final transaction.*/
        return dp[0][0];
    }

    // Function to find the maximum profit
    public int stockBuySell(int[] arr, int n, int fee) {
        // Return the answer
        return func(arr, n, fee);
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int n = prices.length;
        int fee = 1;

        // Create an instance of the stockBuySellvtabu class
        stockBuySellvtabu sol = new stockBuySellvtabu();

        // Call the function and print the result
        System.out.println("The maximum profit that can be generated is " + sol.stockBuySell(prices, n, fee));
    }
}
