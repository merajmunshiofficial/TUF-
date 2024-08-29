import java.util.*;

class minimumRateToEatBananas {
    /* Helper function to find the
    maximum element in the array*/
    private int findMax(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int n = nums.length;

        // Find the maximum element
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, nums[i]);
        }
        return maxi;
    }

    /* Helper function to calculate total
    hours required at given hourly rate*/
    private int calculateTotalHours(int[] nums, int hourly) {
        int totalH = 0;
        int n = nums.length;

        // Calculate total hours required
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double) nums[i] / (double) hourly);
        }
        return totalH;
    }

    /* Function to find the 
    minimum rate to eat bananas*/
    public int minimumRateToEatBananas(int[] nums, int h) {
        // Initialize binary search bounds
        int low = 1, high = findMax(nums);

        // Apply binary search
        while (low <= high) {
            int mid = (low + high) / 2;
            int totalH = calculateTotalHours(nums, mid);
            if (totalH <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {7, 15, 6, 3};
        int h = 8;

        // Create an object of the minimumRateToEatBananas class
        minimumRateToEatBananas sol = new minimumRateToEatBananas();

        int ans = sol.minimumRateToEatBananas(nums, h);

        // Print the result
        System.out.println("Koko should eat at least " + ans + " bananas/hr.");
    }
}
