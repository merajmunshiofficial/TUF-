import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Definition for a binary tree node.
 class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { data = val; left = null; right = null; }
}

class postorderStack1 {
    public List<Integer> postorder(TreeNode root) {
        // List to store postorder traversal result
        List<Integer> result = new ArrayList<>();  
        if (root == null) return result;

        // Stack to manage nodes
        Stack<TreeNode> stack = new Stack<>();  
        TreeNode current = root;
        TreeNode prev = null;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                // Push current node to stack
                stack.push(current);  
                // Move to left child
                current = current.left;  
            }

            // Peek the top of the stack
            current = stack.peek();  
            if (current.right == null || current.right == prev) {
                // Add node data to result
                result.add(current.data); 
                // Remove node from stack 
                stack.pop();  
                // Update previous node
                prev = current;  
                // Move to next node
                current = null;  
            } else {
                // Move to right child
                current = current.right; 
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Create a simple binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // Create postorderStack1 object and call postorder method
        postorderStack1 sol = new postorderStack1();
        List<Integer> result = sol.postorder(root);

        // Print the result
        System.out.println(result);  // Output: [4, 5, 2, 6, 3, 1]
    }
}


