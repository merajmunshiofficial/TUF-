package ARRAY;

import java.util.*;

class mergetwoSortedArray {
    // Function to merge two sorted arrays nums1 and nums2
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int len = n + m;
        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            int left = 0;
            int right = left + gap;
            while (right < len) {
                
                // When left in nums1[] and right in nums2[]
                if (left < m && right >= m) {
                    swapIfGreater(nums1, nums2, left, right - m);
                }
                // When both pointers in nums2[]
                else if (left >= m) {
                    swapIfGreater(nums2, nums2, left - m, right - m);
                }
                // When both pointers in nums1[]
                else {
                    swapIfGreater(nums1, nums1, left, right);
                }
                // Increment the pointers by 1 each
                left++;
                right++;
            }
            // If gap is equal, break out of the loop
            if (gap == 1)
                break;
            gap = (gap / 2) + (gap % 2);
        }

        // Copy elements of nums2 into nums1
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
    }

    // Utility function to swap elements if needed
    private void swapIfGreater(int[] arr1, int[] arr2, int idx1, int idx2) {
        if (arr1[idx1] > arr2[idx2]) {
            
            int temp = arr1[idx1];
            arr1[idx1] = arr2[idx2];
            arr2[idx2] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {-5, -2, 4, 5, 0, 0, 0};
        int[] nums2 = {-3, 1, 8};
        int m = 4, n = 3;

        // Create an instance of the mergetwoSortedArray class
        mergetwoSortedArray sol = new mergetwoSortedArray();

        sol.merge(nums1, m, nums2, n);

        // Output the merged arrays
        System.out.println("The merged array is:");
        System.out.print("nums1[] = ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
