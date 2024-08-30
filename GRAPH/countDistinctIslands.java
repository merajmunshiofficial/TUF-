import java.util.*;

class Solution {
    // DelRow and delCol for neighbors
    private int[] delRow = {-1, 0, 1, 0};
    private int[] delCol = {0, -1, 0, 1};

    /* Helper function to check if a 
    cell is within boundaries */
    private boolean isValid(int i, int j, 
                            int n, int m) {
                        
        // Return false if cell is invalid
        if(i < 0 || i >= n) return false;
        if(j < 0 || j >= m) return false;
        
        // Return true if cell is valid
        return true;
    }
    
    // Function for DFS traversal of island
    private void dfs(int row, int col, int[][] grid, 
                     boolean[][] visited, List<int[]> path, 
                     int base_row, int base_col) {
                         
        // Get the dimensions of grid
        int n = grid.length;
        int m = grid[0].length;

        /* Add relative position of current 
        cell with respect to the base cell */
        path.add(new int[]{row-base_row, col-base_col});
        
        // Traverse the 4 neighbors
        for(int i = 0; i < 4; i++) {
            
            // Get coordinates of new cell
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            
            // Traverse unvisited, valid, land cell
            if(isValid(nRow, nCol, n, m) && 
               grid[nRow][nCol] == 1 && 
               !visited[nRow][nCol]) {
                   
                // Mark the cell as visited
                visited[nRow][nCol] = true;
                
                // Recursively call DFS for the new cell
                dfs(nRow, nCol, grid, visited, path, base_row, base_col);
            }
        }
        
        // Return after all neighbors are explored
        return;
    }

    /* Function to count the count of
    distinct islands in the given grid */
    public int countDistinctIslands(int[][] grid) {
        
        // Get the dimensions of grid
        int n = grid.length;
        int m = grid[0].length;

        // 2-D Visited array
        boolean[][] visited = new boolean[n][m];
        
        // Set to store traversal of unique islands
        Set<List<int[]>> st = new HashSet<>();
        
        // Traverse the grid
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                
                /* Start BFS traversal if an 
                unvisited land cell is found */
                if(grid[i][j] == 1 && !visited[i][j]) {
                    
                    // Mark the cell as visited
                    visited[i][j] = true;
                    
                    // To store the path of cells
                    List<int[]> path = new ArrayList<>();
                    
                    // Start DFS traversal from the cell
                    dfs(i, j, grid, visited, path, i, j);
                    
                    // Add the path of explored island to the set
                    st.add(path);
                }
            }
        }
        
        return st.size();
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 0, 1, 1}, 
            {1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1},
            {1, 1, 0, 1, 1}
        };

        /* Creating an instance of 
        Solution class */
        Solution sol = new Solution();

        /* Function to count the count of
        distinct islands in the given grid */
        int ans = sol.countDistinctIslands(grid);

        // Output
        System.out.println("The count of distinct islands in the given grid is: " + ans);
    }
}
