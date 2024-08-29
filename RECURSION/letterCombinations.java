package RECURSION;

import java.util.ArrayList;
import java.util.List;

class letterCombinations {
    private final String[] map;

    public letterCombinations() {
        // Mapping digits to corresponding characters
        map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    }

    // Recursive helper function to generate combinations
    private void helper(String digits, List<String> ans, int index, String current) {
        // Base case: if index reaches the end of digits
        if (index == digits.length()) {
            // Add the current combination to the answer
            ans.add(current);
            return;
        }
        // Get characters corresponding to the current digit
        String s = map[digits.charAt(index) - '0'];
        // Loop through the corresponding characters
        for (int i = 0; i < s.length(); i++) {
            // Recursively call function with next index
            // Add current character to the string
            helper(digits, ans, index + 1, current + s.charAt(i));
        }
    }

    // Function to get all letter combinations for a given digit string
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>(); // List to store results
        // Return empty list if digits string is empty
        if (digits.length() == 0) return ans;
        // Initiate recursive function
        helper(digits, ans, 0, "");
        return ans; // Return the result
    }

    // Main method to demonstrate the usage of the letterCombinations class
    public static void main(String[] args) {
        letterCombinations letterCombinations = new letterCombinations();
        String digits = "23"; // Input digits
        List<String> result = letterCombinations.letterCombinations(digits); // Get combinations

        // Print the results
        for (String combination : result) {
            System.out.print(combination + " ");
        }
    }
}
