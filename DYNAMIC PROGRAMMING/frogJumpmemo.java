import java.util.Arrays;

class frogJumpmemo {
    private int solve(int ind, int[] heights, int[] dp) {
        // Base case
        if (ind == 0) return 0; 
        // Memoized result
        if (dp[ind] != -1) return dp[ind]; 

        int jumpOne = solve(ind - 1, heights, dp) + Math.abs(heights[ind] - heights[ind - 1]);
        int jumpTwo = Integer.MAX_VALUE;
        if (ind > 1)
            jumpTwo = solve(ind - 2, heights, dp) + Math.abs(heights[ind] - heights[ind - 2]);
        // Store and return result
        return dp[ind] = Math.min(jumpOne, jumpTwo); 
    }

    public int frogJump(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        // Start solving from the last stair
        return solve(n - 1, heights, dp); 
    }

    public static void main(String[] args) {
        int[] heights = {30, 10, 60, 10, 60, 50};
        frogJumpmemo sol = new frogJumpmemo();
        // Output the result
        System.out.println(sol.frogJump(heights)); 
    }
}
