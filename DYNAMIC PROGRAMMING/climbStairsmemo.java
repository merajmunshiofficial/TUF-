import java.util.*;

class climbStairsmemo {
    //Helper function to apply memoization
   private int func(int n, int dp[]){
        //Base condition
        if (n <= 1) {
            return 1;
        }
        
        //Check if the subproblem is already solved
        if (dp[n] != -1) {
            return dp[n];
        }
        
        //Return the calculated value
        return dp[n] = func(n-1, dp) + func(n-2, dp);
    }
    // Function to count total ways to reach nth stair
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        
        // Initialize dp array with -1
        Arrays.fill(dp, -1);
        
        // Return the calculated value
        return dp[n] = func(n, dp);
    }
    
    public static void main(String[] args) {
        int n = 5;
        
        // Create an instance of climbStairsmemo class
        climbStairsmemo sol = new climbStairsmemo();
        
        // Print the answer
        System.out.println("The total number of ways: " + sol.climbStairs(n));
    }
}
