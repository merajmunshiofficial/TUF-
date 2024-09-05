import java.util.Arrays;

class frogJumpspace {
    public int frogJump(int[] heights) {
        int n = heights.length;
        int prev = 0, prev2 = 0; // Initialize for base cases

        // Iterative calculation
        for (int i = 1; i < n; i++) {
            int jumpOne = prev + Math.abs(heights[i] - heights[i - 1]);
            int jumpTwo = Integer.MAX_VALUE;
            if (i > 1)
                jumpTwo = prev2 + Math.abs(heights[i] - heights[i - 2]);
                
            // Minimum energy for current stair
            int cur_i = Math.min(jumpOne, jumpTwo); 
            // Update previous values
            prev2 = prev; 
            prev = cur_i;
        }
        // Return the minimum energy required to reach the last stair
        return prev; 
    }

    public static void main(String[] args) {
        int[] heights = {30, 10, 60, 10, 60, 50};
        frogJumpspace sol = new frogJumpspace();
        // Output the result
        System.out.println(sol.frogJump(heights)); 
    }
}
