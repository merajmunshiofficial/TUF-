package TRIES;

import java.util.*;

class Node {
    Node[] links = new Node[26];

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }
}

class countDistinct {
    // Count number of distinct substrings in string
    public int countDistinct(String s) {
        int c = 0;
        // Root node of the trie
        Node root = new Node();

        // Iterate all starting positions of substrings
        for (int i = 0; i < s.length(); i++) {
            Node node = root;

            // Iterate through characters
            for (int j = i; j < s.length(); j++) {
                /*If the current character is not 
                a child of the current node, 
                insert it as a new child node*/
                if (!node.containsKey(s.charAt(j))) {
                    c++;
                    // Insert new child node for character s[j]
                    node.put(s.charAt(j), new Node());
                }
                // Move to the child node
                node = node.get(s.charAt(j));
            }
        }

        // Clean up the allocated memory
        deleteTrie(root);
        /*Return the total 
        count of distinct 
        substrings including 
        the empty string*/
        return c + 1;
    }

    // Freeing up memory
    private void deleteTrie(Node node) {
        for (int i = 0; i < 26; i++) {
            if (node.links[i] != null) {
                deleteTrie(node.links[i]);
            }
        }
    }

    public static void main(String[] args) {
        countDistinct countDistinct = new countDistinct();

        // Test case 1
        String s1 = "aabbaba";
        System.out.println("Input: " + s1);
        System.out.println("Number of distinct substrings: " + countDistinct.countDistinct(s1));

        // Test case 2
        String s2 = "abcdefg";
        System.out.println("Input: " + s2);
        System.out.println("Number of distinct substrings: " + countDistinct.countDistinct(s2));
    }
}
