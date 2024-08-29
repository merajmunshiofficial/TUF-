package RECURSION;

import java.util.ArrayList;
import java.util.List;

class solveNQueens {

    // Check if it's safe to place a queen at board[row][col]
    public boolean safe(List<String> board, int row, int col) {
        int r = row, c = col;
        
        // Check upper left diagonal
        while (r >= 0 && c >= 0) {
            if (board.get(r).charAt(c) == 'Q') return false;
            r--;
            c--;
        }

        // Reset to the original position
        r = row;
        c = col;
        
        // Check left side
        while (c >= 0) {
            if (board.get(r).charAt(c) == 'Q') return false;
            c--;
        }

        // Reset to the original position
        r = row;
        c = col;
        
        // Check lower left diagonal
        while (r < board.size() && c >= 0) {
            if (board.get(r).charAt(c) == 'Q') return false;
            r++;
            c--;
        }

        // If no queens are found, it's safe
        return true;
    }

    // Function to place queens on the board
    public void func(int col, List<List<String>> ans, List<String> board) {
        // If all columns are filled, add the solveNQueens to the answer
        if (col == board.size()) {
            ans.add(new ArrayList<>(board));
            return;
        }

        // Try placing a queen in each row for the current column
        for (int row = 0; row < board.size(); row++) {
            // Check if it's safe to place a queen
            if (safe(board, row, col)) {
                // Place the queen
                char[] charArray = board.get(row).toCharArray();
                charArray[col] = 'Q';
                board.set(row, new String(charArray));
                
                // Recursively place queens in the next columns
                func(col + 1, ans, board);
                
                // Remove the queen and backtrack
                charArray[col] = '.';
                board.set(row, new String(charArray));
            }
        }
    }

    // Solve the N-Queens problem
    public List<List<String>> solveNQueens(int n) {
        // List to store the solveNQueenss
        List<List<String>> ans = new ArrayList<>();
        // Initialize the board with empty cells
        List<String> board = new ArrayList<>();
        String s = ".".repeat(n);
        for (int i = 0; i < n; i++) {
            board.add(s);
        }

        // Start placing queens from the first column
        func(0, ans, board);
        return ans;
    }

    // Main method to test the solveNQueens
    public static void main(String[] args) {
        solveNQueens solveNQueens = new solveNQueens();
        int n = 4; // Example with 4 queens
        List<List<String>> solveNQueenss = solveNQueens.solveNQueens(n);
        
        // Print all solveNQueenss
        for (List<String> sol : solveNQueenss) {
            for (String row : sol) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
