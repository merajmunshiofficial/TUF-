import java.util.*;

class nextGreaterElements {

    /* Function to find the next greater element
    for each element in the circular array */
    public int[] nextGreaterElements(int[] arr) {
        
        int n = arr.length; // size of array
        
        // To store the next greater elements
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        
        for(int i = 0; i < n; i++) {
            
            // Get the current element
            int currEle = arr[i];
            
            /* Nested loop to get the 
            next greater element */
            for(int j = 1; j < n; j++) {
                
                // Getting the hypothetical index
                int ind = (j + i) % n;
                
                // If the next greater element is found
                if(arr[ind] > currEle) {
                    
                    // Store the next greater element
                    ans[i] = arr[ind];
                    
                    // Break from the loop
                    break;
                }    
            }
        }
        
        // Return the answer
        return ans;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] arr = {5, 7, 1, 7, 6, 0};
        
        /* Creating an instance of 
        nextGreaterElements class */
        nextGreaterElements sol = new nextGreaterElements(); 
        
        /* Function call to find the next greater element
        for each element in the circular array */
        int[] ans = sol.nextGreaterElements(arr);
        
        System.out.println("The next greater elements are: ");
        for(int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
