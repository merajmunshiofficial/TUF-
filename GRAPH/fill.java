import java.util.List;
import java.util.ArrayList;
import java.util.*;

class fill {
    // DelRow and delCol for neighbors
    private int[] delRow = {-1, 0, 1, 0};
    private int[] delCol = {0, 1, 0, -1};
    
    /* Helper Function to check if 
    a cell is within boundaries */
    private boolean isValid(int i, int j, 
                            int n, int m) {
                                
        // Return false if cell is invalid
        if (i < 0 || i >= n) return false;
        if (j < 0 || j >= m) return false;
        
        // Return true if cell is valid
        return true;
    }
    
    // Recursive function to perform DFS
    private void dfs(int row, int col, 
                    boolean[][] vis, 
                    char[][] mat, 
                    int n, int m) {
                        
        // Mark the node as visited
        vis[row][col] = true;
        
        // Check the 4 neighbors
        for (int i = 0; i < 4; i++) {
            
            // Determine coordinates of new cell
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            
            // If an unvisited, valid cell contains 'O'
            if (isValid(nRow, nCol, n, m) && 
                mat[nRow][nCol] == 'O' && 
                !vis[nRow][nCol]) {
                    
                // Recursive DFS traversal
                dfs(nRow, nCol, vis, mat, n, m);
            }
        }
    }
    
    // Function to replace surrounded 'O's with 'X's
    public char[][] fill(char[][] mat) {
        // Determine the dimensions of matrix
        int n = mat.length;
        int m = mat[0].length;
        
        // Visited array
        boolean[][] vis = new boolean[n][m];
        
        // Traverse the boundaries
        
        // Traversal for boundary rows
        for (int j = 0; j < m; j++) {
            // Check for unvisited 'O's in boundary rows
            
            // First row
            if (!vis[0][j] && mat[0][j] == 'O') {
                // Start DFS traversal from current node
                dfs(0, j, vis, mat, n, m);
            }
            
            // Last row
            if (!vis[n - 1][j] && mat[n - 1][j] == 'O') {
                // Start DFS traversal from current node
                dfs(n - 1, j, vis, mat, n, m);
            }
        }
        
        // Traversal for boundary columns
        for (int i = 0; i < n; i++) {
            // Check for unvisited 'O's in boundary columns
            
            // First column
            if (!vis[i][0] && mat[i][0] == 'O') {
                // Start DFS traversal from current node
                dfs(i, 0, vis, mat, n, m);
            }
            
            // Last column
            if (!vis[i][m - 1] && mat[i][m - 1] == 'O') {
                // Start DFS traversal from current node
                dfs(i, m - 1, vis, mat, n, m);
            }
        }
        
        /* Traverse the matrix and convert 
        the unvisited 'O's into 'X' */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                // Check for unvisited 'O's
                if (mat[i][j] == 'O' && !vis[i][j]) {
                    mat[i][j] = 'X';
                }
            }
        }
        
        // Return the updated matrix
        return mat;
    }
    
    public static void main(String[] args) {
        char[][] mat = {
            {'X', 'X', 'X', 'X'}, 
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        
        // Creating an instance of fill class
        fill sol = new fill();
        
        // Function call to replace surrounded 'O's with 'X's
        char[][] ans = sol.fill(mat);
        
        int n = ans.length;
        int m = ans[0].length;
        
        // Output
        System.out.println("The updated matrix is:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
