import java.util.List;
import java.util.ArrayList;
import java.util.*;

class asteroidCollision {

    /* Function to determine the state of 
    asteroids after all collisions */
    public int[] asteroidCollision(int[] asteroids) {
        
        // Size of the array
        int n = asteroids.length;
        
        // List implementation of stack
        List<Integer> st = new ArrayList<>();  
        
        // Traverse all the asteroids
        for(int i = 0; i < n; i++) {
            
            /* Push the asteroid in stack if a 
            right moving asteroid is seen */
            if(asteroids[i] > 0) {
                st.add(asteroids[i]);
            }
            
            /* Else if the asteroid is moving 
            left, perform the collisions */
            else {
                
                /* Until the right moving asteroids are 
                smaller in size, keep on destroying them */ 
                while(!st.isEmpty() && st.get(st.size() - 1) > 0 && 
                      st.get(st.size() - 1) < Math.abs(asteroids[i])) {
                    
                    // Destroy the asteroid
                    st.remove(st.size() - 1);
                }
                
                /* If there is right moving asteroid 
                which is of same size */
                if(!st.isEmpty() && 
                    st.get(st.size() - 1) == Math.abs(asteroids[i])) {
                    
                    // Destroy both the asteroids
                    st.remove(st.size() - 1);
                }
                
                /* Otherwise, if there is no left
                moving asteroid, the right moving 
                asteroid will not be destroyed */
                else if(st.isEmpty() ||
                        st.get(st.size() - 1) < 0){
                    
                    // Storing the array in final state
                    st.add(asteroids[i]);
                }
            }
        }
        
        // Convert list to array
        int[] result = new int[st.size()];
        for(int i = 0; i < st.size(); i++) {
            result[i] = st.get(i);
        }
        
        // Return the final state of asteroids
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, -10};
        
        /* Creating an instance of 
        asteroidCollision class */
        asteroidCollision sol = new asteroidCollision(); 
        
        /* Function call to determine the state of 
        asteroids after all collisions */
        int[] ans = sol.asteroidCollision(arr);
        
        System.out.print("The state of asteroids after collisions is: ");
        for(int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
