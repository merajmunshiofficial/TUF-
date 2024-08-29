class floorSqrt {
    /* Function to compute the floor of
       square root of a given integer */
    public long floorSqrt(long n) {
        long low = 1, high = n;
        
        // Binary search on the answer space
        while (low <= high) {
            long mid = (long)(low + high) / 2;
            long val = mid * mid;
            
            // Check if val is less than or equal to n
            if (val <= (long)(n)) {
                // Move to the right part
                low = (int)(mid + 1);
            } else {
                // Move to the left part
                high = (int)(mid - 1);
            }
        }
        
        // Return the floor of square root
        return high;
    }

    public static void main(String[] args) {
        int n = 28;
        
        // Create an object of the floorSqrt class
        floorSqrt sol = new floorSqrt();
        
        long ans = sol.floorSqrt(n);
        
        // Print the result
        System.out.println("The floor of square root of " + n + " is: " + ans);
    }
}
