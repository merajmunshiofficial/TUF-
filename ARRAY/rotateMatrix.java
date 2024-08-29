package ARRAY;

class rotateMatrix {
    //Rotate the given matrix by 90 degrees clockwise.
    
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                
                // Swap elements across the diagonal
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
                
            }
        }
        
        // Reverse each row of the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                
                // Swap elements symmetrically
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
                
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        
        // Create an instance of the rotateMatrix class
        rotateMatrix sol = new rotateMatrix();
        
        // Rotate the matrix
        sol.rotate(arr);
        
        // Output the rotated matrix
        System.out.println("Rotated Image:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
