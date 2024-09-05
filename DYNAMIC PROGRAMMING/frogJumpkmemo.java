import java.util.*;

class frogJumpkmemo {
    // Helper function for recursion with memoization
    private int func(int ind, int[] heights, int k, int[] dp) {
        // Base case
        if (ind == 0) {
            return 0;
        }
        
        /* If the result for this index has been 
        previously calculated, return it*/
        if (dp[ind] != -1) {
            return dp[ind];
        }
        
        // Initialize mmStep to Integer.MAX_VALUE
        int mmStep = Integer.MAX_VALUE;
        
        // Try all possible jumps
        for (int j = 1; j <= k; j++) {
            
            // Check if ind - j is non-negative
            if (ind - j >= 0) {
                int jump = func(ind - j, heights, k, dp) + Math.abs(heights[ind] - heights[ind - j]);
                
                //Update the minimum energy
                mmStep = Math.min(jump, mmStep);
            }
        }
        
        // Store the result in dp array and return
        dp[ind] = mmStep;
        return dp[ind];
    }
    
    /* Function to find the minimum 
    energy to reach the last stair*/
    public int frogJump(int[] heights, int k) {
        int ind = heights.length - 1;
        
        /* Initialize a memoization array
        to store calculated results*/
        int[] dp = new int[ind + 1];
        Arrays.fill(dp, -1);
        
        // Return the minimum energy
        return func(ind, heights, k, dp);
    }
    
    public static void main(String[] args) {
        int[] heights = {15, 4, 1, 14, 15};
        int k = 3;
        
        // Create an instance of frogJumpkmemo class
        frogJumpkmemo sol = new frogJumpkmemo();
        
        // Print the answer
        System.out.println("Minimum energy: " + sol.frogJump(heights, k));
    }
}
