class minTriangleSumspace {
    // Function to find minimum path sum using space optimization
    private int func(int[][] triangle, int n) {
        /* Create two arrays to store the
        current and previous row values*/
        
        // Represents the previous row
        int[] front = new int[n];
        
        // Represents the current row
        int[] cur = new int[n];
    
        /* Initialize the front array with values
        from the last row of the triangle*/
        for (int j = 0; j < n; j++) {
            front[j] = triangle[n - 1][j];
        }
    
        // Iterate through triangle rows in reverse order
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                // Calculate minimum path sum for current cell
                int down = triangle[i][j] + front[j];
                int diagonal = triangle[i][j] + front[j + 1];
            
                /* Store the minimum of the two 
                possible paths in the current row*/
                cur[j] = Math.min(down, diagonal);
            }
            /* Update the front array with
            the values from the current row*/
            front = cur.clone();
        }
    
        /* The front array now contains the minimum path 
        sum from the top to the bottom of the triangle*/
        return front[0];
    }

    // Function to find out the minimum path sum
    public int minTriangleSum(int[][] triangle) {
        // Get the number of rows in the triangle
        int n = triangle.length;
    
        // Return the minimum path sum
        return func(triangle, n);
    }

    public static void main(String[] args) {
        int[][] triangle = {
            {1},
            {2, 3},
            {3, 6, 7},
            {8, 9, 6, 10}
        };
        
        // Create an instance of minTriangleSumspace class
        minTriangleSumspace sol = new minTriangleSumspace();
        
        // Call the minTriangleSum function and print result
        System.out.println(sol.minTriangleSum(triangle));
    }
}
