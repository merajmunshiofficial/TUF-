package ARRAY;

import java.util.*;

class intersectionArray {
   //Function to find intersection of two sorted arrays
    public List<Integer> intersectionArray(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;

        // Traverse both arrays using two pointers approach
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums2[j] < nums1[i]) {
                j++;
            } 
            // nums1[i] == nums2[j]
            else {
                ans.add(nums1[i]);
                i++;
                j++;
            }
        }

        //Return the intersection of two arrays
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 3, 4, 5, 6, 7};
        int[] nums2 = {3, 3, 4, 4, 5, 8};

        // Create an instance of the intersectionArray class
        intersectionArray finder = new intersectionArray();

        // Get intersection of nums1 and nums2 using class method
        List<Integer> ans = finder.intersectionArray(nums1, nums2);

        System.out.println("Intersection of nums1 and nums2 is:");
        for (int val : ans) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
