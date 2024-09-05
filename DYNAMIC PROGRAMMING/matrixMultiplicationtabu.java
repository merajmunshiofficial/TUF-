class matrixMultiplicationtabu {
    public int matrixMultiplication(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        // Initialize the dp array with large values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        // A single matrix doesn't require any multiplication
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // Filling the dp array in a bottom-up manner
        for (int length = 2; length < n; length++) {
            for (int i = 1; i <= n - length; i++) {
                int j = i + length - 1;
                for (int k = i; k < j; k++) {
                    // Calculate cost
                    int cost = dp[i][k] + dp[k + 1][j] + nums[i - 1] * nums[k] * nums[j];
                    // Take the minimum cost
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }

        // The result is in dp[1][n-1] (multiplying from matrix 1 to n-1)
        return dp[1][n - 1];
    }

    // Main method to test the matrixMultiplicationtabu
    public static void main(String[] args) {
        matrixMultiplicationtabu sol = new matrixMultiplicationtabu();
        int[] nums = {10, 15, 20, 25};
        // Output should be 8000
        System.out.println(sol.matrixMultiplication(nums)); 
    }
}
