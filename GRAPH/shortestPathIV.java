import java.util.*;

class Solution {

    // Delta row and column array
    private int[] delRow = {-1, 0, 1, 0};
    private int[] delCol = {0, -1, 0, 1};

    // Function to check if a cell is valid
    private boolean isValid(int row, int col, 
                            int n, int m) {

        // Return false if the cell is invalid
        if (row < 0 || row >= n) return false;
        if (col < 0 || col >= m) return false;
        
        // Return true if the cell is valid
        return true;
    }

    /* Function to determine the shortest distance
    between source and destination */
    public int shortestPath(int[][] grid, int[] source, 
                            int[] destination) {

        // Edge Case
        if (source[0] == destination[0] && 
            source[1] == destination[1])
            return 0;

        /* Queue data structure to store the pairs of the 
        form: {dist, {coordinates of cell}} */
        Queue<int[]> q = new LinkedList<>();
        
        // Dimensions of grid
        int n = grid.length;
        int m = grid[0].length;

        // Distance matrix
        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        // Distance of source from itself is zero
        dist[source[0]][source[1]] = 0;
        
        // Add the source to queue
        q.add(new int[]{0, source[0], source[1]});

        // Until the queue is empty
        while (!q.isEmpty()) {
            // Get the element
            int[] it = q.poll();
            
            int dis = it[0]; // Distance
            int row = it[1]; // Row of cell
            int col = it[2]; // Column of cell

            // Iterate through all the neighbors
            for (int i = 0; i < 4; i++) {
                
                // Coordinates of the new cell
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                /* Checking the validity of the cell and 
                updating if a shorter distance is found */
                if (isValid(newRow, newCol, n, m) && 
                    grid[newRow][newCol] == 1 && 
                    dis + 1 < dist[newRow][newCol]) {
                    
                    // Update the distance
                    dist[newRow][newCol] = 1 + dis;

                    /* Return the distance if the 
                    destination is reached */
                    if (newRow == destination[0] && 
                        newCol == destination[1])
                        return dis + 1;
                    
                    // Add the new cell to queue
                    q.add(new int[]{1 + dis, newRow, newCol});
                }
            }
        }
        
        // If no path is found from source to destination
        return -1;
    }

    public static void main(String[] args) {
        int[] source = {0, 1};
        int[] destination = {2, 2};
        
        int[][] grid = {
            {1, 1, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {1, 0, 0, 1}
        };
        
        /* Creating an instance of 
        Solution class */
        Solution sol = new Solution();
        
        /* Function call to determine the shortest 
        distance between source and destination */
        int ans = sol.shortestPath(grid, source, destination);
        
        System.out.println("The shortest distance from the source to destination is: " + ans);
    }
}
