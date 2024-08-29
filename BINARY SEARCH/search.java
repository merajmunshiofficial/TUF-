import java.util.*;

class search {
    // Function to find the given target in a sorted array
    public int search(int[] nums, int target) {
        int n = nums.length; // Size of array 
        
        // Pointers to define the search space
        int low = 0, high = n - 1;

        // Until the search space is not empty
        while (low <= high) {
            // Find the middle element
            int mid = (low + high) / 2;

            // If it matches the target
            if (nums[mid] == target) 
                return mid; 
                
            // If the target is greater than middle element 
            else if (target > nums[mid]) 
                low = mid + 1; 
                
            // Otherwise
            else 
                high = mid - 1; 
        }

        // If the target is not found
        return -1; 
    }

    public static void main(String[] args) {
        int[] a = {-1, 0, 3, 5, 9, 12}; 
        int target = 9; 

        // Creating an instance of search class
        search sol = new search(); 

        // Function call to find the given target in a sorted array
        int ind = sol.search(a, target); 
        
        if (ind == -1) 
            System.out.println("The target is not present.");
        else 
            System.out.println("The target is at index: " + ind);
    }
}