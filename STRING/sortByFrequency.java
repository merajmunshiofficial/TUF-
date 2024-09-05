package STRING;

/*
    Time Complexity: O(N*log(N))
    Space Complexity: O(N)

    Where 'N' is length of the string
*/
import java.util.Comparator;
import java.util.Map;
import java.util.*;

// Custom Pair class.
class Pair<T, U> {
    private final T first;
    private final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
public class sortByFrequency {
    public static String sortByFrequency(int n, String s) {
        StringBuilder ans = new StringBuilder();
        Set<Pair<Integer,Character>> ch = new HashSet<Pair<Integer,Character>>(); 
        
        char[] arr = s.toCharArray();
        // Sort the string to make charcaters together.
        Arrays.sort(arr);
        s = new String(arr);

        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && s.charAt(i) == s.charAt(j)) {
                j++;
            }

            // Store frequency and character.
            ch.add(new Pair<>(-(j - i), s.charAt(i)));
            i = j - 1;
        }

        for (Pair<Integer, Character> entry : ch) {
            
            // Concatenating it->first number of it->second character to string.
            for (int i = 0; i < Math.abs(entry.getFirst()); i++) {
                ans.append(entry.getSecond());
            }
        }
        return ans.toString();
    }
}