class NthRoot {
    /* Helper function to check the power of mid
    with respect to m Returns: 1 - if mid^n == m,
    0 - if mid^n < m and 2 - if mid^n > m*/ 
    private int func(int mid, int n, int m) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= mid;
            if (ans > m) return 2;
        }
        if (ans == m) return 1;
        return 0;
    }

    /* Function to find the nth root
    of m using binary search*/
    public int NthRoot(int N, int M) {
        // Binary search on the answer space
        int low = 1, high = M;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midN = func(mid, N, M);
            if (midN == 1) {
                // Return mid if mid^N == M
                return mid;
            } else if (midN == 0) {
                // Move to the right half if mid^N < M
                low = mid + 1;
            } else {
                // Move to the left half if mid^N > M
                high = mid - 1;
            }
        }
        // Return -1 if no nth root found
        return -1;
    }
    
    public static void main(String[] args) {
        int n = 3, m = 27;
        
        // Create an object of the NthRoot class
        NthRoot sol = new NthRoot();
        
        int ans = sol.NthRoot(n, m);
        
        // Print the result
        System.out.println("The answer is: " + ans);
    }
}
