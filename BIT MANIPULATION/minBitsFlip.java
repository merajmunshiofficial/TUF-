public class minBitsFlip {
    /* Function to get the minimum
     bit flips to convert number */
    public int minBitsFlip(int start, int goal) {
        
        /* Variable to store bits that
        are different in both numbers */
        int num = start ^ goal;
        
        /* Variable to count 
        number of set bits */
        int count = 0;

        for (int i = 0; i < 32; i++) {
            /* Update count if the 
            rightmost bit is set */
            count += (num & 1); 
            
            /* Shift the number every 
            time by 1 place */
            num = num >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int start = 10, goal = 7;
        
        /* Creating an instance of 
        minBitsFlip class */
        minBitsFlip sol = new minBitsFlip(); 
        
        /* Function call to get the minimum
         bit flips to convert number */
        int ans = sol.minBitsFlip(start, goal);
        
        System.out.println("The minimum bit flips to convert number is: " + ans);
    }
}
