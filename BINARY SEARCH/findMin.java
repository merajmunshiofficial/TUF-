import java.util.*;

class findMin {
    /* Function to find minimum element
    in a rotated sorted array */
    public int findMin(ArrayList<Integer> arr) {
        // Initialize low and high indices
        int low = 0, high = arr.size() - 1;
        
        // Initialize ans to maximum integer value
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            
            // Check if left part is sorted
            if (arr.get(low) <= arr.get(mid)) {
                /* Update ans with minimum 
                of ans and arr[low] */
                ans = Math.min(ans, arr.get(low));
                
                // Move to the right part
                low = mid + 1;
            } else {
                /* Update ans with minimum 
                   of ans and arr[mid] */
                ans = Math.min(ans, arr.get(mid));
                
                // Move to the left part
                high = mid - 1;
            }
        }
        // Return the minimum element found
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 0, 1, 2, 3));
    
        //Create an instance of the findMin class
        findMin sol = new findMin();
        
        int ans = sol.findMin(arr);
        
        System.out.println("The minimum element is: " + ans);
    }
}
