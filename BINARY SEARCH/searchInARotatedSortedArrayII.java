import java.util.*;

public class searchInARotatedSortedArrayII {
    /* Function to search for the target element 
       in a rotated sorted array with duplicates */
    public boolean searchInARotatedSortedArrayII(int[] arr, int target) {
        int n = arr.length;
        int low = 0, high = n - 1;
        
        // Applying binary search algorithm 
        while (low <= high) {
            int mid = (low + high) / 2;

            // Check if mid points to the target
            if (arr[mid] == target) return true;

            // Handle duplicates: if arr[low], arr[mid], and arr[high] are equal
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }

            // Check if the left part is sorted
            if (arr[low] <= arr[mid]) {
                /* Eliminate the right part if target
                   exists in the left sorted part */
                if (arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1;
                } 
                // Otherwise eliminate the left part
                else {
                    low = mid + 1;
                }
            } else {
                /* If the right part is sorted and
                   target exists in the right sorted
                   part, eliminate the left part */
                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;
                } 
                // Otherwise eliminate the right part
                else {
                    high = mid - 1;
                }
            }
        }
        // If target is not found
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        int target = 3; 

        // Create an instance of the searchInARotatedSortedArrayII class
        searchInARotatedSortedArrayII sol = new searchInARotatedSortedArrayII();

        // Function call to search for the target element
        boolean result = sol.searchInARotatedSortedArrayII(arr, target);

        if (!result)
            System.out.println("Target is not present.");
        else
            System.out.println("Target is present in the array.");
    }
}