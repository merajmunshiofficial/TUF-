import java.util.*;

class climbStairsspace {
    // Function to count total ways to reach nth stair
    public int climbStairs(int n) {
        /*Initialize two variables to 
        store previous results*/
        int prev2 = 1;
        int prev = 1;
        
        //Iterate and update the variables
        for (int i = 2; i <= n; i++) {
            int cur_i = prev2 + prev;
            prev2 = prev;
            prev = cur_i;
        }
        //Return the answer as prev
        return prev;
    }

    public static void main(String[] args) {
        int n = 3;

        // Create an instance of climbStairsspace class
        climbStairsspace sol = new climbStairsspace();

        // Print the answer
        System.out.println("The total number of ways: " + sol.climbStairs(n));
    }
}
