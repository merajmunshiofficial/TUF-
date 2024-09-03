package TRIES;
import java.util.*;

class Node {
    Node[] links = new Node[2];

    // To check if a specific bit key is present in the child nodes
    boolean containsKey(int bit) {
        return links[bit] != null;
    }

    // To get the child node corresponding to a specific bit
    Node get(int bit) {
        return links[bit];
    }

    // To set a child node at a specific index in the links array
    void put(int bit, Node node) {
        links[bit] = node;
    }
}

// Trie class
class Trie {
    private Node root;

    // Constructor
    Trie() {
        root = new Node();
    }

    // To insert number in Trie
    void insert(int num) {
        // Start from the root
        Node node = root;
        // Iterate each bit
        for (int i = 31; i >= 0; i--) {
            // Extract i-th bit
            int bit = (num >> i) & 1;
            /* If the current node doesn't 
           have a child node with the 
           current bit */
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    // Method to find the maximum XOR 
    int getMax(int num) {
        // Start from root
        Node node = root;
        // Initialize maximum XOR value
        int maxNum = 0;
        // Iterate each bit
        for (int i = 31; i >= 0; i--) {
            // Extract the i-th bit 
            int bit = (num >> i) & 1;
            /*If the complement of the current bit 
            exists in the Trie update the maximum 
            XOR value with the current bit
            move to the child node corresponding to 
            the complement of the current bit
            Else move to the child node 
            corresponding to the current bit */
            if (node.containsKey(1 - bit)) {
                maxNum |= (1 << i);
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }
        // Return maximum XOR
        return maxNum;
    }
}

// findMaximumXOR class
class findMaximumXOR {
    public int findMaximumXOR(int[] nums) {
        // Create Trie
        Trie trie = new Trie();
        // Insert number
        for (int num : nums) {
            trie.insert(num);
        }

        // Maximum XOR value
        int maxi = 0;

        // Iterate each number
        for (int num : nums) {
            // Update the maximum XOR
            maxi = Math.max(maxi, trie.getMax(num));
        }

        // Return maximum XOR value
        return maxi;
    }

    // Main function
    public static void main(String[] args) {
        findMaximumXOR findMaximumXOR = new findMaximumXOR();

        // Test case
        int[] nums = {3, 10, 5, 25, 2, 8};

        // Print the input array
        System.out.print("Input: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Find and print the maximum XOR value
        int result = findMaximumXOR.findMaximumXOR(nums);
        System.out.println("Maximum XOR value: " + result);
    }
}
