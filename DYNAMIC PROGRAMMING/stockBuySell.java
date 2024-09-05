import java.util.*;

class stockBuySell {
    // Function to calculate the maximum profit earned
    public int stockBuySell(int[] arr, int n) {
        int maxProfit = 0;
        // Initialize mini to the first element of arr
        int mini = arr[0]; 

        // Traverse through the array 
        for (int i = 1; i < n; i++) {
            // Calculate current profit
            int curProfit = arr[i] - mini; 
            
            // Update maxProfit if curProfit is larger
            maxProfit = Math.max(maxProfit, curProfit); 
            
            // Update mini to minimum value encountered so far
            mini = Math.min(mini, arr[i]); 
        }
        // Return the maximum profit
        return maxProfit; 
    }

    public static void main(String[] args) {
        int[] Arr = {7, 1, 5, 3, 6, 4};
        int n = 6;

        // Create an instance of stockBuySell class
        stockBuySell sol = new stockBuySell();

        // Call stockBuySell function and print the result
        System.out.println("The maximum profit by selling the stock is " + sol.stockBuySell(Arr, n));
    }
}
