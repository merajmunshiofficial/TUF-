/**
 * Definition for a binary tree node.
 */
 class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { data = val; left = null; right = null; }
}

class recoverTree {
    private TreeNode first = null, middle = null, last = null, prev = null;

    public void recoverTree(TreeNode root) {
        inorder(root); // Perform inorder traversal to identify the misplaced nodes

        // Correct the BST by swapping the misplaced nodes
        if (first != null && last != null) {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        } else if (first != null && middle != null) {
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        // Traverse the left subtree
        inorder(node.left);

        // Identify the nodes that are out of order
        if (prev != null && prev.data > node.data) {
            if (first == null) {
                first = prev;  // First out-of-order node
                middle = node; // Middle node in case nodes are adjacent
            } else {
                last = node;   // Last out-of-order node
            }
        }

        prev = node; // Update prev node to the current node

        // Traverse the right subtree
        inorder(node.right);
    }

    // Main method to demonstrate the recoverTree
    public static void main(String[] args) {
        // Example input tree: [1, 3, null, null, 2]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        // recoverTree instance
        recoverTree sol = new recoverTree();
        sol.recoverTree(root);

        // Helper function to print inorder traversal of the tree
        inorderPrint(root);
    }

    private static void inorderPrint(TreeNode root) {
        if (root != null) {
            inorderPrint(root.left);
            System.out.print(root.data + " ");
            inorderPrint(root.right);
        }
    }
}
