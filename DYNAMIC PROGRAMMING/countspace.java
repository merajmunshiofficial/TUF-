import java.util.*;

class countspace {
    /* Function to count the number of 
    ways to make change for the target sum */
    public int count(int[] coins, int N, int amount) {
        // Initialize a vector to store previous DP state
        int[] prev = new int[amount + 1];  

        // Initialize base condition
        for (int i = 0; i <= amount; i++) {
            /* There is one way to make change
            for multiples of the first coin */
            if (i % coins[0] == 0)
                prev[i] = 1;  
            /* Else condition is automatically fulfilled,
            as the prev array is initialized to zero*/
        }

        for (int ind = 1; ind < N; ind++) {
            // Initialized an array to store current DP state
            int[] cur = new int[amount + 1];  
            for (int target = 0; target <= amount; target++) {
                
                // Number of ways without taking current coin
                int notTaken = prev[target];  

                int taken = 0;
                if (coins[ind] <= target)
                    // Number of ways by taking current coin
                    taken = cur[target - coins[ind]];  
                
                // Total number of ways for current target
                cur[target] = notTaken + taken;  
            }
            /* Update the previous DP state with 
            the current state for the next coin */
            prev = cur;  
        }
        /* Return the total number of ways
        to make change for the target */
        return prev[amount];  
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int amount = 4;
        int N = coins.length; 
        
        // Create an instance of countspace class
        countspace sol = new countspace();

        // Print the result
        System.out.println("The total number of ways is " + sol.count(coins, N, amount));
    }
}


