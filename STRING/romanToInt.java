package STRING;

/*
    Time Complexity     :   O(N)
    Space Complexity    :   O(N)

    Where 'N' is the length of the string.
*/

import java.util.HashMap;

public class romanToInt {
    public static int romanToInt(String s) {
        int count = 0;

        // To store previous char value.
        int preInt = 0;

        // Hash map for finding interger value for roman numerals.
        HashMap<Character, Integer> conv = new HashMap<>();
        conv.put('I', 1);
        conv.put('V', 5);
        conv.put('X', 10);
        conv.put('L', 50);
        conv.put('C', 100);
        conv.put('D', 500);
        conv.put('M', 1000);

        // Loop from end to start of the string.
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            // Store current char integer value.
            int curInt = conv.get(ch);

            /*
                If current value is greater or equal to previous value then increment count i.e., II means 1+1
                else in case of IV, V = 5 and I = 1 here 1 < 5 then else part will execute and update count as 5 - 1 = 4.
            */
            if (curInt >= preInt) {
                count += curInt;
            } else {
                count -= curInt;
            }

            // Update 'preInt' value with current value for next iteration.
            preInt = curInt;
        }
        return count;
    }
}