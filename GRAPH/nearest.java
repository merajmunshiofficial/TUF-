import java.util.*;

class Solution {
    // DelRow and delCol for neighbors
    private int[] delRow = {-1, 0, 1, 0};
    private int[] delCol = {0, 1, 0, -1};
    
    /* Helper Function to check if a 
    the cell is within boundaries */
    private boolean isValid(int i, int j, 
                            int n, int m) {
        
        // Return false if the cell is invalid
        if(i < 0 || i >= n) return false;
        if(j < 0 || j >= m) return false;
        
        // Return true if the cell is valid
        return true;
    }
    
    /* Function to find the distance of the 
    nearest 1 in the grid for each cell. */
    public int[][] nearest(int[][] grid) {
        
        // Determine the dimensions
        int n = grid.length;
        int m = grid[0].length;
        
        // visited and distance matrix
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];
        
        // Queue to store the pair {coordinates, steps}
        Queue<int[]> q = new LinkedList<>();
        
        // Traverse the matrix
        for(int i=0; i < n; i++) {
            for(int j=0; j < m; j++) {
                
                // Start BFS if the cell contains 1
                if(grid[i][j] == 1) {
                    q.add(new int[]{i, j, 0});
                    vis[i][j] = 1;
                }
                else {
                    // mark unvisited 
                    vis[i][j] = 0;
                }
            }
        }
        
        // Traverse till the queue becomes empty
        while(!q.isEmpty()) {
            
            // Determine the top of the queue
            int[] it = q.poll();
            
            // Determine the coordinates of the cell
            int row = it[0];
            int col = it[1];
            
            // Get the steps
            int steps = it[2];
            
            // Update the distance matrix
            dist[row][col] = steps;
            
            // Traverse the 4 neighbors
            for(int i = 0; i < 4; i++) {
                
                // Coordinates of new cell
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];
                
                // Check for valid, unvisited cell
                if(isValid(nRow, nCol, n, m) && 
                   vis[nRow][nCol] == 0) {
                    
                    // Mark the cell as visited
                    vis[nRow][nCol] = 1;
                    q.add(new int[]{nRow, nCol, steps + 1});
                }
            }
        }
        
        // return distance matrix
        return dist;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] grid = {
            {0, 1, 1, 0}, 
            {1, 1, 0, 0}, 
            {0, 0, 1, 1}
        };
        
        /* Creating an instance of 
        Solution class */
        Solution sol = new Solution();
        
        /* Function call to find the distance of the 
        nearest 1 in the grid for each cell. */
        int[][] ans = sol.nearest(grid);
        
        int n = ans.length;
        int m = ans[0].length;
        
        // Output
        System.out.println("The distance of the nearest 1 in the grid for each cell is: ");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
