class uniquePathsspace {
    // Function to solve the problem using space optimization
    int func(int m, int n) {
        /* Create an array to represent 
        the previous row of the grid*/
        int[] prev = new int[n];

        // Iterate through the rows of the grid
        for (int i = 0; i < m; i++) {
            /* Initialize a temporary array to
            represent the current row*/
            int[] temp = new int[n];

            for (int j = 0; j < n; j++) {
                // Base case
                if (i == 0 && j == 0) {
                    temp[j] = 1;
                    continue;
                }

                /* Initialize variables to store the number
                of ways from cell above (up) and left (left)*/
                int up = (i > 0) ? prev[j] : 0;
                int left = (j > 0) ? temp[j - 1] : 0;

                /* Calculate the number of ways to reach
                the current cell by adding 'up' and 'left'*/
                temp[j] = up + left;
            }

            /* Update the previous array with values
            calculated for the current row*/
            prev = temp;
        }

        /* The result is stored in the last
        cell of the previous row (n-1)*/
        return prev[n - 1];
    }

    /* Function to count the total ways
    to reach (0,0) from (m-1,n-1)*/
    public int uniquePaths(int m, int n) {
        // Return the total count (0-based indexing)
        return func(m, n);
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 2;

        // Create an instance of uniquePathsspace class
        uniquePathsspace sol = new uniquePathsspace();

        // Call the uniquePaths function and print the result
        System.out.println("Number of ways: " + sol.uniquePaths(m, n));
    }
}
