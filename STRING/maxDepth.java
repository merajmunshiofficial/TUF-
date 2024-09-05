package STRING;


/*
    Time Complexity: O( N )
    Space Complexity: O( 1 )

    Where 'N' is the length of the string 'S'.
*/
public class maxDepth {
    public static int maxDepth(String s) {
        // Initialize two integer variables, 'maxNestingDepth' and 'currentDepth' with 0.
        int maxNestingDepth = 0, currentDepth = 0;

        // For each character 'c' in 's':
        for (char c : s.toCharArray()) {

            // If 'c' equals '(':
            if (c == '(') {

                // Update 'currentDepth' and 'maxNestingDepth'.
                currentDepth++;
                maxNestingDepth = Math.max(maxNestingDepth, currentDepth);
            }

            // If 'c' equals ')':
            else if (c == ')') {

                // Decrement current depth.
                currentDepth--;
            }
        }

        // Return 'maxNestingDepth'.
        return maxNestingDepth;
    }
}