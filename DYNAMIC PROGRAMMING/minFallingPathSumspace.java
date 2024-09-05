import java.util.*;

class minFallingPathSumspace {
    /* Function to find the minimum
    path sum in the given matrix */
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Represents previous row's minimum path sums
        int[] prev = new int[m];

        // Represents current row's minimum path sums
        int[] cur = new int[m];

        // Initialize the first row (base condition)
        for (int j = 0; j < m; j++) {
            prev[j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                /* Calculate the minimum path sum for the
                current cell considering three possible
                directions: up, left diagonal, and right diagonal */

                // Up direction
                int up = matrix[i][j] + prev[j];

                // Left diagonal direction
                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += prev[j - 1];
                } else {
                    leftDiagonal = Integer.MAX_VALUE;
                }

                // Right diagonal direction
                int rightDiagonal = matrix[i][j];
                if (j + 1 < m) {
                    rightDiagonal += prev[j + 1];
                } else {
                    rightDiagonal = Integer.MAX_VALUE;
                }

                /* Store the minimum of the
                three paths in the current row */
                cur[j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }

            /* Update the 'prev' array with the values
            from the 'cur' array for the next iteration */
            System.arraycopy(cur, 0, prev, 0, m);
        }

        /* Find the minimum value in the last row of 'prev',
        which represents minimum path sums ending at each cell */
        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, prev[j]);
        }

        /* The minimum path sum is the minimum
        value in the last row of 'prev' */
        return mini;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 10, 4},
            {100, 3, 2, 1},
            {1, 1, 20, 2},
            {1, 2, 2, 1}
        };

        // Create an instance of minFallingPathSumspace class
        minFallingPathSumspace sol = new minFallingPathSumspace();

        // Call the minFallingPathSum function and print the result
        System.out.println(sol.minFallingPathSum(matrix));
    }
}
