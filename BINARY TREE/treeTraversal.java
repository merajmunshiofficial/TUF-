import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.*;


// Node structure for the binary tree
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

public class treeTraversal {
    // Function to get the Preorder, Inorder, and Postorder traversals
    // of Binary Tree in One traversal
    public static List<List<Integer>> treeTraversal(TreeNode root) {
        // Lists to store traversals
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        // If the tree is empty, return empty traversals
        if (root == null) {
            return Arrays.asList(pre, inOrder, post);
        }

        // Stack to maintain nodes and their traversal state
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();

        // Start with the root node and state 1 (preorder)
        stack.push(new Pair<>(root, 1));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> it = stack.pop();

            // Process the node based on its state
            if (it.getValue() == 1) {
                // Preorder: Add node data
                pre.add(it.getKey().data);
                // Change state to 2 (inorder) for this node
                it.setValue(2);
                // Push the updated state back onto the stack
                stack.push(it);

                // Push left child onto the stack for processing
                if (it.getKey().left != null) {
                    stack.push(new Pair<>(it.getKey().left, 1));
                }
            } else if (it.getValue() == 2) {
                // Inorder: Add node data
                inOrder.add(it.getKey().data);
                // Change state to 3 (postorder) for this node
                it.setValue(3);
                // Push the updated state back onto the stack
                stack.push(it);

                // Push right child onto the stack for processing
                if (it.getKey().right != null) {
                    stack.push(new Pair<>(it.getKey().right, 1));
                }
            } else {
                // Postorder: Add node data
                post.add(it.getKey().data);
            }
        }

        // Returning the traversals as a list of lists
        return Arrays.asList(pre, inOrder, post);
    }

    // Function to print the elements of a list
    public static void printList(List<Integer> list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main function to test the tree traversal
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Getting the Preorder, Inorder, and Postorder traversals
        List<List<Integer>> traversals = treeTraversal(root);

        // Extracting the traversals from the result
        List<Integer> pre = traversals.get(0);
        List<Integer> inOrder = traversals.get(1);
        List<Integer> post = traversals.get(2);

        // Printing the traversals
        System.out.print("Preorder traversal: ");
        printList(pre);

        System.out.print("Inorder traversal: ");
        printList(inOrder);

        System.out.print("Postorder traversal: ");
        printList(post);
    }
}
