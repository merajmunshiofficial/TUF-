import java.util.*;

class nonAdjacentmemo {
    // Function to solve the problem using memoization
    private int func(int ind, int[] arr, int[] dp) {
        // Base cases
        if (ind == 0)
            return arr[ind];
        if (ind < 0)
            return 0;

        /* Check if the result for 'ind'
        has already been computed*/
        if (dp[ind] != -1)
            return dp[ind];

        // Choosing the current element
        int pick = arr[ind] + func(ind - 2, arr, dp);

        // Skipping the current element
        int nonPick = func(ind - 1, arr, dp);

        /* Store the result in dp 
        array and return the maximum */
        return dp[ind] = Math.max(pick, nonPick);
    }

    /* Function to calculate the maximum
    sum of non-adjacent elements */
    public int nonAdjacent(int[] nums) {
        int ind = nums.length - 1;

        // Initialize the dp array with -1
        int[] dp = new int[ind + 1];
        Arrays.fill(dp, -1);

        // Return the maximum sum
        return func(ind, nums, dp);
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 9};

        // Create an instance of nonAdjacentmemo class
        nonAdjacentmemo sol = new nonAdjacentmemo();

        // Call the nonAdjacent function and print the result
        System.out.println(sol.nonAdjacent(arr));
    }
}
