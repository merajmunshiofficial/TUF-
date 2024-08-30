import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

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

class succPredBST {
    private static final int MAX_VALUE = Integer.MAX_VALUE;
    private int predecessor = -1;
    private int successor = MAX_VALUE;
    
    public List<Integer> succPredBST(TreeNode root, int key) {
        traverse(root, key);
        return Arrays.asList(predecessor == -1 ? -1 : predecessor, successor == MAX_VALUE ? -1 : successor);
    }
    
    private void traverse(TreeNode node, int key) {
        if (node == null) {
            return;
        }
        
        if (node.data < key) {
            // Update predecessor and move to the right subtree
            predecessor = Math.max(predecessor, node.data);
            traverse(node.right, key);
        } else if (node.data > key) {
            // Update successor and move to the left subtree
            successor = Math.min(successor, node.data);
            traverse(node.left, key);
        } else {
            // If node's value equals key, find predecessor and successor in subtrees
            if (node.left != null) {
                // Find maximum value in left subtree for predecessor
                TreeNode temp = node.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                predecessor = temp.data;
            }
            
            if (node.right != null) {
                // Find minimum value in right subtree for successor
                TreeNode temp = node.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                successor = temp.data;
            }
        }
    }

    // Example usage
    public static void main(String[] args) {
        // Create the BST
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(12);
        
        // Create succPredBST object and get the predecessor and successor
        succPredBST sol = new succPredBST();
        System.out.println(sol.succPredBST(root, 10));  // Output: [7, 12]
    }
}
