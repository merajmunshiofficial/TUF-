package STRING;

/*
	Time complexity : O(2 ^ (N / 2))
	Space complexity : O(2 ^ (N / 2))
    
	where 'N' is the given sequence index.
*/

public class lookAndSaySequence {

	public static String lookAndSaySequence(int n) {

		// Previous string.
		String prev = "1";

		// Current string.
		String cur = prev;

		for (int i = 2; i <= n; i++) {

			cur = "";
			int count = 1;

			for (int j = 1; j < prev.length(); j++) {
		
				if(prev.charAt(j) != prev.charAt(j - 1)) {
					cur += Integer.toString(count);
					cur += prev.charAt(j - 1);
					count = 1;
				} else {
					count += 1;
				}

			}

			cur += Integer.toString(count);
			cur += prev.charAt(prev.length() - 1);
			prev = cur;

		}

		return cur;
	}
}