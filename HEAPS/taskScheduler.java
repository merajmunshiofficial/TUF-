package HEAPS;

/*
   Time complexity: O(n)
   Space complexity: O(c)

   Where 'n' is the number of tasks and 'c' is a constant equal to 26.
*/

import java.util.Arrays;

public class taskScheduler {

        public static int taskScheduler(String s, int n, int k) {

                // initialise frequency array of size 26 with values 0
                int[] freq = new int[26];
                Arrays.fill(freq, 0);

                // Maximum frequency of task and number of task with that maximum frequency.
                int maxFreq = 0, countMaxFreq = 0;

                // Iterate over string to find maximum frequency of task and number of task with
                // that maximum frequency.
                for (int i = 0; i < n; i++) {

                        char ch = s.charAt(i);

                        freq[ch - 'A']++;

                        if (freq[ch - 'A'] > maxFreq) {
                                maxFreq = freq[ch - 'A'];
                                countMaxFreq = 1;
                        }
                        else if (freq[ch - 'A'] == maxFreq) {
                                countMaxFreq++;
                        }
                }

                // Calculate and return minimum time required.
                return Math.max((int) s.length(), (maxFreq - 1) * (k + 1) + countMaxFreq);
        }
}
