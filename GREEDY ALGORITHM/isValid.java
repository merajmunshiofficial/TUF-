class isValid {
    public boolean isValid(String s) {
        int minOpen = 0, maxOpen = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++; // Treat as opening
                maxOpen++; // Treat as opening
            } else if (c == ')') {
                minOpen--; // Treat as closing
                maxOpen--; // Treat as closing
            } else if (c == '*') {
                minOpen--; // Treat as closing
                maxOpen++; // Treat as opening
            }
            if (maxOpen < 0) return false; // More closing parentheses than opening
            if (minOpen < 0) minOpen = 0; // Reset minOpen if negative
        }
        return minOpen == 0; // Check if balanced
    }

    public static void main(String[] args) {
        isValid sol = new isValid();
        String s = "(({}))";
        System.out.println(sol.isValid(s) ? "true" : "false");
    }
}
