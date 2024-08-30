// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class maxDepth {
    public int maxDepth(TreeNode root) {
        // Base case: if the node is null, return 0
        if (root == null) {
            return 0;
        }
        // Recursively find the depth of the left and right subtrees
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // The depth of the tree is 1 current node + the maximum depth of the subtrees
        return 1 + Math.max(left, right);
    }

    // Main method to test the function
    public static void main(String[] args) {
        maxDepth maxDepth = new maxDepth();
        // Example usage:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        System.out.println("Maximum Depth: " + maxDepth.maxDepth(root));
    }
}
