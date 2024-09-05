import java.util.Arrays;

class frogJumptabu {
    public int frogJump(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        // Base case
        dp[0] = 0; 

        // Iterative calculation
        for (int ind = 1; ind < n; ind++) {
            int jumpOne = dp[ind - 1] + Math.abs(heights[ind] - heights[ind - 1]);
            int jumpTwo = Integer.MAX_VALUE;
            if (ind > 1)
            // Store minimum energy for this stair
                jumpTwo = dp[ind - 2] + Math.abs(heights[ind] - heights[ind - 2]);
            dp[ind] = Math.min(jumpOne, jumpTwo); 
        }
        // Return the minimum energy required to reach the last stair
        return dp[n - 1]; 
    }

    public static void main(String[] args) {
        int[] heights = {30, 10, 60, 10, 60, 50};
        frogJumptabu sol = new frogJumptabu();
        // Output the result
        System.out.println(sol.frogJump(heights)); 
    }
}
