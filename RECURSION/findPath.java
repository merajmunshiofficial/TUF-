package RECURSION;

import java.util.*;

class findPath {
    // List to store the resulting paths
    List<String> result = new ArrayList<>();

    // Recursive function to find paths
    private void path(int[][] m, int x, int y, String dir, int n) {
        // If destination is reached, add path to result
        if (x == n - 1 && y == n - 1) {
            result.add(dir);
            return;
        }

        // If cell is blocked, return
        if (m[x][y] == 0) return;

        // Mark cell as visited by setting it to 0
        m[x][y] = 0;

        // Move up if possible
        if (x > 0) path(m, x - 1, y, dir + 'U', n);
        // Move left if possible
        if (y > 0) path(m, x, y - 1, dir + 'L', n);
        // Move down if possible
        if (x < n - 1) path(m, x + 1, y, dir + 'D', n);
        // Move right if possible
        if (y < n - 1) path(m, x, y + 1, dir + 'R', n);

        // Unmark cell as visited by setting it to 1
        m[x][y] = 1;
    }

    public List<String> findPath(int[][] grid) {
        int n = grid.length;

        // Clear previous results
        result.clear();

        // If starting or ending cell is blocked, return empty result
        if (grid[0][0] == 0 || grid[n - 1][n - 1] == 0) return result;

        // Start finding paths from (0, 0)
        path(grid, 0, 0, "", n);

        // Sort the result paths
        Collections.sort(result);

        return result;
    }

    public static void main(String[] args) {
        findPath sol = new findPath();
        int[][] grid = {
            {1, 0, 0, 0, 0},
            {1, 1, 0, 1, 1},
            {0, 1, 0, 0, 1},
            {0, 1, 1, 1, 1},
            {0, 0, 0, 0, 1}
        };

        List<String> paths = sol.findPath(grid);

        for (String path : paths) {
            System.out.println(path);
        }
    }
}
