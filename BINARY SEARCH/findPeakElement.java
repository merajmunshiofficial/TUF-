import java.util.*;

class findPeakElement {
    // Function to find peak element in the array
    public int findPeakElement(int[] arr) {
        // Size of array
        int n = arr.length;
        
        // Edge cases:
        if (n == 1) return 0;
        if (arr[0] > arr[1]) return 0;
        if (arr[n - 1] > arr[n - 2]) return n - 1;

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;

            //If arr[mid] is the peak
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1])
                return mid;

            // If we are in the left
            if (arr[mid] > arr[mid - 1]) low = mid + 1;

            /* If we are in the right
            Or, arr[mid] is a common point*/
            else high = mid - 1;
        }
        /* Return -1 if no peak element
        found (dummy return) */
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 5, 1};
        
        // Create an instance of the findPeakElement class
        findPeakElement sol = new findPeakElement();
        
        int ans = sol.findPeakElement(arr);
        
        // Output the result
        System.out.println("The peak is at index: " + ans);
    }
}
