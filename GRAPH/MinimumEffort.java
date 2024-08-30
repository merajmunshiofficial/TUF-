import java.util.*;

class Solution {

    // Delta row and column array
    int[] delRow = {-1, 0, 1, 0};
    int[] delCol = {0, -1, 0, 1};

    // Function to check if a cell is valid
    boolean isValid(int row, int col, int n, int m) {
        // Return false if the cell is invalid
        if (row < 0 || row >= n) return false;
        if (col < 0 || col >= m) return false;

        // Return true if the cell is valid
        return true;
    }

    /* Function to determine minimum efforts 
    to go from top-left to bottom-right */
    public int MinimumEffort(List<List<Integer>> heights) {

        // Get the dimensions of grid
        int n = heights.size();
        int m = heights.get(0).size();

        // To store maximum difference
        int[][] maxDiff = new int[n][m];
        for (int[] row : maxDiff)
            Arrays.fill(row, Integer.MAX_VALUE);

        /* Min-Heap storing the pair: 
        {diff, {row of cell, column of cell}} */
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Mark the initial position as 0
        maxDiff[0][0] = 0;

        // Push the starting cell to min-heap
        pq.add(new int[]{0, 0, 0});

        // Until the min-heap is not empty
        while (!pq.isEmpty()) {

            /* Get the cell with minimum 
            difference (effort) */
            int[] p = pq.poll();

            // Get the difference
            int diff = p[0];

            int row = p[1]; // Row
            int col = p[2]; // Column

            /* If the destination cell is reached, 
            return the difference */
            if (row == n - 1 && col == m - 1)
                return diff;

            // Traverse its neighbors
            for (int i = 0; i < 4; i++) {

                /* Get the coordinates 
                of neighboring cell */
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                // Check if the cell is valid
                if (isValid(newRow, newCol, n, m)) {

                    /* Get the current difference 
                    in heights of cells */
                    int currDiff = Math.abs(heights.get(newRow).get(newCol) - heights.get(row).get(col));

                    /* Check if the current difference is 
                    less than earlier known difference */
                    if (Math.max(currDiff, diff) < maxDiff[newRow][newCol]) {

                        // Store the current difference
                        maxDiff[newRow][newCol] = Math.max(currDiff, diff);

                        // Add the new pair found in the min-heap
                        pq.add(new int[]{Math.max(currDiff, diff), newRow, newCol});
                    }
                }
            }
        }

        // Return -1
        return -1;
    }

    public static void main(String[] args) {

        List<List<Integer>> heights = Arrays.asList(
                Arrays.asList(1, 2, 2),
                Arrays.asList(3, 8, 2),
                Arrays.asList(5, 3, 5)
        );

        /* Creating an instance of 
        Solution class */
        Solution sol = new Solution();

        /* Function call to determine minimum efforts 
        to go from top-left to bottom-right */
        int ans = sol.MinimumEffort(heights);

        // Output
        System.out.println("The minimum efforts required to go from cell (0,0) to cell (row-1, col-1) is: " + ans);
    }
}
