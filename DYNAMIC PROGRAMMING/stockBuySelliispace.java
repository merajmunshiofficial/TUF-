import java.util.*;

class stockBuySelliispace {
    // Function to find maximum profit using space optimization
    private int func(int[] arr, int n) {
        /* Declare two arrays to store the profits ahead of 
        current position (0 for not holding, 1 for holding)*/
        int[] ahead = new int[2];
        int[] cur = new int[2];

        // Base condition
        ahead[0] = ahead[1] = 0;

        int profit = 0;

        // Loop through the array in reverse order
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                // We can buy the stock
                if (buy == 0) { 
                    profit = Math.max(0 + ahead[0], (-1)*arr[ind] + ahead[1]);
                }
                // We can sell the stock
                if (buy == 1) { 
                    profit = Math.max(0 + ahead[1], arr[ind] + ahead[0]);
                }
                cur[buy] = profit;
            }
            // Update the "ahead" array with the current values
            ahead = cur;
        }

        // Maximum profit is stored in cur[0] 
        return cur[0];
    }

    // Function to calculate the maximum profit earned
    public int stockBuySell(int[] arr, int n){
        // Return the maximum profit
        return func(arr, n);
    }

    public static void main(String[] args) {
        int n = 6;
        int[] arr = {7, 1, 5, 3, 6, 4};
        
        // Create an instance of stockBuySelliispace class
        stockBuySelliispace sol = new stockBuySelliispace();

        // Call the stockBuySell function and print the result
        System.out.println("The maximum profit that can be generated is " + sol.stockBuySell(arr, n));
    }
}
