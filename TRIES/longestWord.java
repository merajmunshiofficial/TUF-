package TRIES;
import java.util.*;

class Node {
    Node[] links = new Node[26]; 
    boolean flag = false;  

    // To check if the node contains a child node
    boolean containsKey(char ch) {
        return (links[ch - 'a'] != null); 
    }

    // To get the child node
    Node get(char ch) {
        return links[ch - 'a']; 
    }

    // To set a child node
    void put(char ch, Node node) {
        links[ch - 'a'] = node;  
    }

    // To mark the node as the end of a word
    void setEnd() {
        flag = true; 
    }

    // To check if the node marks the end of a word
    boolean isEnd() {
        return flag;  
    }
}

// Implementing Trie
class Trie {
    private Node root;  

    // Constructor
    Trie() {
        // Create a new root node for the Trie
        root = new Node();  
    }

    // Method to insert a word into the Trie
    void insert(String word) {
        Node node = root; 
        // Iterate each character
        for (char ch : word.toCharArray()) {  
           /* If the character doesn't exist 
           as a child node create a new node 
           for the character */
            if (!node.containsKey(ch)) { 
                node.put(ch, new Node()); 
            }
            // Move to next node
            node = node.get(ch);  
        }
        /* Mark last node 
        as end of the word */
        node.setEnd(); 
    }

    // To check if all prefixes of a given word exist in Trie
    boolean checkIfAllPrefixExists(String word) {
        // Traversal from root node
        Node node = root; 
        // Iterate each character
        for (char ch : word.toCharArray()) {  
            // If character exists as child node
            if (node.containsKey(ch)) {
                // Move to next node
                node = node.get(ch);  
                // Check if current node is end of word
                if (!node.isEnd()) return false;
            } else {
                return false; 
            }
        }
        // Return true if all prefixes exist
        return true; 
    }
}

class longestWord {
    // To find the longest word
    public String longestWord(String[] words) {
        // Create a Trie object
        Trie obj = new Trie();  
        // Insert each word into the Trie
        for (String word : words)  
            obj.insert(word);
        
        // Initialize variable
        String longest = "";
        // Iterate through each word in the array
        for (String word : words) {  
            // Check if all prefixes of the word exist
            if (obj.checkIfAllPrefixExists(word)) { 
                // Update the longest string if the current word
                // is longer or lexicographically smaller
                if (word.length() > longest.length() || (word.length() == longest.length() && word.compareTo(longest) < 0)) {
                    // Update the longest string
                    longest = word; 
                }
            }
        }
        // Return an empty string 
        if (longest.isEmpty()) 
            return ""; 
        // Return longest string
        return longest;  
    }

    public static void main(String[] args) {
        // Create an instance of the longestWord class
        longestWord sol = new longestWord();

        // Initialize an array of strings
        String[] strings = {"striver", "strive", "striving", "striven", "strived", "striv"};

        // Find the longest complete string in the array
        String longestComplete = sol.longestWord(strings);

        // Print the longest complete string
        System.out.println("Longest complete string: " + longestComplete);
    }
}
