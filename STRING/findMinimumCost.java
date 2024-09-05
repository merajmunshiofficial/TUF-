package STRING;

/*
    Time Complexity : O(|STR|)
    Space Complexity : O(|STR|)

    Where |STR| is the length of STR.
*/

import java.util.Deque;
import java.util.LinkedList;

public class findMinimumCost 
{
	public static int findMinimumCost(String str) 
	{
		int n = str.length();

		// If lenght is odd then it is impossible to make str valid.
		if (n % 2 == 1) 
		{
			return -1;
		}

		// To store invalid parts.
		Deque<Character> open = new <Character>LinkedList();
		Deque<Character> close = new <Character>LinkedList();

		int price = 0;

		for (int i = 0; i < str.length(); i++) 
		{
			if (str.charAt(i) == '}') 
			{

				if (open.isEmpty()) 
				{
					// Keep the invalid part in the stack.
					price++;
					open.add(str.charAt(i));
				} 
				else 
				{
					// Remove the valid part in the stack.
					open.removeLast();
				}

			} 
			else 
			{
				// Keep the invalid part in the stack.
				open.add(str.charAt(i));
			}


		}

		if (open.isEmpty()) 
		{

			if (close.size() % 2 == 1) 
			{
				return -1;
			} 
			else 
			{
				return (close.size() / 2) + price;
			}
		} 
		else 
		{

			if (open.size() % 2 == 1) 
			{
				return -1;
			} 
			else 
			{
				return (open.size() / 2) + price;
			}

		}
	}
}