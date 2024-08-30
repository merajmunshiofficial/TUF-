/**
 * Definition for a binary tree node.
 */
 class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class largestBST {
    // Helper class to store information about a subtree.
    class NodeValue {
        int minNode, maxNode, maxSize;
        NodeValue(int minNode, int maxNode, int maxSize) {
            this.minNode = minNode;
            this.maxNode = maxNode;
            this.maxSize = maxSize;
        }
    }

    // Helper function to recursively find the largest BST subtree.
    private NodeValue largestBSTSubtreeHelper(TreeNode node) {
        // Base case: if the node is null, return a default NodeValue.
        if (node == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        // Recursively get values from the left and right subtrees.
        NodeValue left = largestBSTSubtreeHelper(node.left);
        NodeValue right = largestBSTSubtreeHelper(node.right);

        // Check if the current node is a valid BST node.
        if (left.maxNode < node.data && node.data < right.minNode) {
            // Current subtree is a valid BST.
            return new NodeValue(
                Math.min(node.data, left.minNode),
                Math.max(node.data, right.maxNode),
                left.maxSize + right.maxSize + 1
            );
        }

        // Current subtree is not a valid BST.
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }

    public int largestBST(TreeNode root) {
        // Initialize the recursive process and return the size of the largest BST subtree.
        return largestBSTSubtreeHelper(root).maxSize;
    }

    // Main method to demonstrate usage
    public static void main(String[] args) {
        // Example binary tree
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        largestBST sol = new largestBST();
        System.out.println(sol.largestBST(root));  // Output: 3

        // Additional test case
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(15);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(8);
        root2.right.right = new TreeNode(7);

        System.out.println(sol.largestBST(root2));  // Output: 3 (The subtree 5-1-8 is the largest BST)
    }
}
