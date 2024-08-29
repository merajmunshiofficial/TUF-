package ARRAY;

import java.util.*;

class numberOfInversions {
    // Function to find number of inversions in an array
    public int numberOfInversions(int[] nums) {
        // Size of the array
        int n = nums.length;

        // Count the number of pairs
        return mergeSort(nums, 0, n - 1);
    }

    /* Merge function to count 
    inversions and merge sorted halves*/
    private int merge(int[] arr, int low, int mid, int high) {
        // Temporary array for merging
        List<Integer> temp = new ArrayList<>();
        
        // Starting indices of left and right halves
        int left = low;
        int right = mid + 1;

        // Count variable to count the pairs
        int cnt = 0;

        // Merge sorted halves into temp array
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                
                // Count inversions
                cnt += (mid - left + 1);
                
                right++;
            }
        }

        // Copy remaining elements of left half
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // Copy remaining elements of right half
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        /* Copy elements from temp 
        array back to original array*/
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
        
        // Return the count of inversions
        return cnt;
    }

    // Merge sort function to recursively sort and count inversions
    private int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            
            // Sort left half
            cnt += mergeSort(arr, low, mid);  
            
            // Sort right half
            cnt += mergeSort(arr, mid + 1, high); 
            
            // Merge and count inversions
            cnt += merge(arr, low, mid, high);  
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        
        // Create an instance of numberOfInversions class
        numberOfInversions sol = new numberOfInversions();

        int result = sol.numberOfInversions(nums);
        
        // Print the number of inversions found
        System.out.println("The number of inversions are: " + result);
    }
}
