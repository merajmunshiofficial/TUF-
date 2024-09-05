import java.util.*;

class nonAdjacenttabu {
    /* Function to calculate the maximum
    sum of nonAdjacent elements */
    public int nonAdjacent(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        
        // Base case
        dp[0] = nums[0];

        // Iterate through the elements of the array
        for (int i = 1; i < n; i++) {
            
            /* Calculate maximum value by either picking
            the current element or not picking it */
            int pick = nums[i];
            if (i > 1)
                pick += dp[i - 2];
            int nonPick = dp[i - 1];

            // Store the maximum value in dp array
            dp[i] = Math.max(pick, nonPick);
        }

        /* The last element of the dp array
        will contain the maximum sum */
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 9};

        // Create an instance of nonAdjacenttabu class
        nonAdjacenttabu sol = new nonAdjacenttabu();

        // Call the solve function and print the result
        System.out.println(sol.nonAdjacent(arr));
    }
}
