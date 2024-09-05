import java.util.*;

class matrixMultiplicationmemo {
    /* Recursive function to compute the 
    minimum cost of matrix multiplication*/
    private int func(int[] arr, int i, int j, int[][] dp) {
        /* Base case: When there is only one 
        matrix, no multiplication is needed*/
        if (i == j)
            return 0;
        
        // Check if the subproblem is already calculated
        if (dp[i][j] != -1)
            return dp[i][j];
        
        int mini = Integer.MAX_VALUE;

        // Partition the matrices between i and j
        for (int k = i; k <= j - 1; k++) {
            /* Compute the cost of multiplying 
            matrices from i to k and from k+1 to j*/
            int ans = func(arr, i, k, dp) + func(arr, k + 1, j, dp) + arr[i - 1] * arr[k] * arr[j];
            
            // Update the minimum cost
            mini = Math.min(mini, ans);
        }
        // Store and return the minimum cost found
        dp[i][j] = mini;
        return mini;
    }

    /* Function to set up the parameters
    and call the recursive function*/
    public int matrixMultiplication(int[] nums) {
        int N = nums.length;

        // Starting index of the matrix chain
        int i = 1;
        
        // Ending index of the matrix chain
        int j = N - 1;

        int[][] dp = new int[N][N];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        // Call the recursive function
        return func(nums, i, j, dp);
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        
        // Create an instance of matrixMultiplicationmemo class
        matrixMultiplicationmemo sol = new matrixMultiplicationmemo();
        
        // Print the result
        System.out.println("The minimum number of operations is " + sol.matrixMultiplication(arr));
    }
}
