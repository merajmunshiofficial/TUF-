package RECURSION;

class checkSubsequenceSum {
    // This method recursively checks for the subsequence with the given sum
    public boolean solve(int i, int n, int[] arr, int k) {
        // Base case: if the sum k is 0, a subsequence is found
        if (k == 0) {
            return true;
        }
        // Base case: if k is negative, no valid subsequence can be found
        if (k < 0) {
            return false;
        }
        // Base case: if all elements are processed, check if k is 0
        if (i == n) {
            return k == 0;
        }
        // Recursive call: include the current element in the subsequence
        // or exclude the current element from the subsequence
        return solve(i + 1, n, arr, k - arr[i]) || solve(i + 1, n, arr, k);
    }

    // This method initiates the recursive process
    public boolean checkSubsequenceSum(int[] nums, int target) {
        int n = nums.length; // Get the length of the input array
        return solve(0, n, nums, target); // Start the recursive process
    }

    // Main method to test the checkSubsequenceSum
    public static void main(String[] args) {
        checkSubsequenceSum sol = new checkSubsequenceSum();
        int[] nums = {1, 2, 3, 4};
        int target = 5;
        System.out.println(sol.checkSubsequenceSum(nums, target)); // Expected output: true
    }
}
