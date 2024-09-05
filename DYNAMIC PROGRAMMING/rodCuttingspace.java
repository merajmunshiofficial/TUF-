import java.util.*;

class rodCuttingspace {
    // Function to solve the rod cutting problem
    public int rodCutting(int[] price, int n) {
        // Initialize DP table with dimensions [n + 1]
        int[] prev = new int[n + 1];
        int[] cur = new int[n + 1];
        
        for (int length = 0; length <= n; length++) {
            prev[length] = price[0] * length;
        }
        
        // Fill the DP table
        for (int ind = 1; ind < n; ++ind) { 
            for (int length = 1; length <= n; ++length) { 
                
                // Case when the piece is not taken
                int notTaken = prev[length];
                
                // Case when the piece is taken
                int taken = Integer.MIN_VALUE;
                
                /* Length of the rod piece 
                corresponding to the current index*/
                int rodLength = ind + 1;
                
                // Check if the piece can be taken
                if (rodLength <= length) {
                    taken = price[ind] + cur[length - rodLength];
                }
                
                /* Update cur[length] with the maximum of 
                including or not including the current piece*/
                cur[length] = Math.max(notTaken, taken);
            }
            // Copy cur to prev
            System.arraycopy(cur, 0, prev, 0, n + 1);
        }
        
        // Return the result
        return prev[n];
    }

    public static void main(String[] args) {
        int[] price = {2, 4, 6, 8};
        int n = price.length;

        // Create an instance of rodCuttingspace class
        rodCuttingspace sol = new rodCuttingspace();

        // Print the result
        System.out.println("The Maximum value is " + sol.rodCutting(price, n));
    }
}
