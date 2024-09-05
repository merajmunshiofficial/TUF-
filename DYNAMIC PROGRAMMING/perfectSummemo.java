import java.util.Arrays;

class perfectSummemo {
    private static final int MODULO = 1000000007;

    /* Function to count the number of 
    subsets with sum k using memoization */
    private int findWaysUtil(int ind, int target, int[] arr, int[][] dp) {
        /* Base case: If the target sum 
        is 0, we found a valid subset */
        if (target == 0)
            return 1;

        /* Base case: If we have considered all elements
        and the target is still not 0, return 0 */
        if (ind == 0)
            return (arr[0] == target) ? 1 : 0;

        /* If the result for this state 
        is already calculated, return it */
        if (dp[ind][target] != -1)
            return dp[ind][target];

        // Exclude the current element
        int notTaken = findWaysUtil(ind - 1, target, arr, dp);

        /* Include the current element if
        it doesn't exceed the target */
        int taken = 0;
        if (arr[ind] <= target)
            taken = findWaysUtil(ind - 1, target - arr[ind], arr, dp);

        /* Store the result in DP table and return
        Also, take modulo for the code to be accepted*/
        return dp[ind][target] = (notTaken + taken) % MODULO;
    }

    // Function to find out number of subsets with sum k
    public int perfectSum(int[] arr, int K) {
        int n = arr.length;

        // DP array to store the subproblems
        int[][] dp = new int[n][K + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Return the result
        return findWaysUtil(n - 1, K, arr, dp);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3};
        int k = 3;

        // Create an instance of perfectSummemo class
        perfectSummemo sol = new perfectSummemo();

        // Print the result
        System.out.println("The number of subsets found are " + sol.perfectSum(arr, k));
    }
}
