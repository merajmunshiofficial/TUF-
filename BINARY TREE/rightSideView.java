import java.util.List;
import java.util.ArrayList;
import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    // Constructor to initialize the node with a value
    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class rightSideView {
    // Function to return the Right view of the binary tree
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        // Call the recursive function to populate the right-side view
        recursionRight(root, 0, res);
        
        return res;
    }

    // Function to return the Left view of the binary tree
    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        // Call the recursive function to populate the left-side view
        recursionLeft(root, 0, res);
        
        return res;
    }

    // Recursive function to traverse the binary tree and populate the left-side view
    private void recursionLeft(TreeNode root, int level, List<Integer> res) {
        // Check if the current node is NULL
        if (root == null) {
            return;
        }
        
        // Check if the size of the result list is equal to the current level
        if (res.size() == level) {
            // If equal, add the value of the current node to the result list
            res.add(root.data);
        }
        
        // Recursively call the function for the left child with an increased level
        recursionLeft(root.left, level + 1, res);
        
        // Recursively call the function for the right child with an increased level
        recursionLeft(root.right, level + 1, res);
    }

    // Recursive function to traverse the binary tree and populate the right-side view
    private void recursionRight(TreeNode root, int level, List<Integer> res) {
        // Check if the current node is NULL
        if (root == null) {
            return;
        }
        
        // Check if the size of the result list is equal to the current level
        if (res.size() == level) {
            // If equal, add the value of the current node to the result list
            res.add(root.data);
        }
        
        // Recursively call the function for the right child with an increased level
        recursionRight(root.right, level + 1, res);
        
        // Recursively call the function for the left child with an increased level
        recursionRight(root.left, level + 1, res);
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(10);
        root.right.left = new TreeNode(9);

        rightSideView rightSideView = new rightSideView();

        // Get the Right View traversal
        List<Integer> rightView = rightSideView.rightSideView(root);

        // Print the result for Right View
        System.out.print("Right View Traversal: ");
        for (int node : rightView) {
            System.out.print(node + " ");
        }
        System.out.println();

        // Get the Left View traversal
        List<Integer> leftView = rightSideView.leftSideView(root);

        // Print the result for Left View
        System.out.print("Left View Traversal: ");
        for (int node : leftView) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}
