
import java.util.List;
import java.util.ArrayList;
import java.util.*;

// Definition for a binary tree node.
  class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode(int val) { data = val; left = null; right = null; }
 }

class bstFromPreorder {
    public TreeNode bstFromPreorder(List<Integer> preorder) {
        // Start the recursive function
        // with the first element as the root
        // and the entire range of valid numbers
        return bstFromPreorderHelper(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    private TreeNode bstFromPreorderHelper(List<Integer> preorder, int bound, int[] index) {
        // If all elements are used or the next element
        // is greater than the bound, return null
        if (index[0] == preorder.size() || preorder.get(index[0]) > bound) return null;

        // Create a new TreeNode with the current value
        TreeNode root = new TreeNode(preorder.get(index[0]++));

        // Recursively construct the left subtree
        // with the current value as the new bound
        root.left = bstFromPreorderHelper(preorder, root.data, index);

        // Recursively construct the right subtree
        // with the same bound as the parent's bound
        root.right = bstFromPreorderHelper(preorder, bound, index);

        // Return the constructed subtree's root
        return root;
    }

    public static void main(String[] args) {
        bstFromPreorder bstFromPreorder = new bstFromPreorder();
        List<Integer> preorder = Arrays.asList(8, 5, 1, 7, 10, 12);
        TreeNode bst = bstFromPreorder.bstFromPreorder(preorder);
        // Add code to print or use the bst as needed
    }
}
