import java.util.List;
import java.util.ArrayList;
import java.util.*;

class TreeNode {
    int data;
    TreeNode left, right;
    TreeNode(int val) { data = val; left = null; right = null; }
}

class zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // List to store the result of zigzag traversal
        List<List<Integer>> result = new ArrayList<>();

        // Check if the root is NULL, return an empty result
        if (root == null) {
            return result;
        }

        // Queue to perform level order traversal
        Queue<TreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);

        // Flag to determine the direction of traversal (left to right or right to left)
        boolean leftToRight = true;

        // Continue traversal until the queue is empty
        while (!nodesQueue.isEmpty()) {
            // Get the number of nodes at the current level
            int size = nodesQueue.size();

            // List to store the values of nodes at the current level
            List<Integer> row = new ArrayList<>(Collections.nCopies(size, 0));

            // Traverse nodes at the current level
            for (int i = 0; i < size; i++) {
                // Get the front node from the queue
                TreeNode node = nodesQueue.poll();

                // Determine the index to insert the node's value based on the traversal direction
                int index = leftToRight ? i : (size - 1 - i);

                // Insert the node's value at the determined index
                row.set(index, node.data);

                // Enqueue the left and right children if they exist
                if (node.left != null) {
                    nodesQueue.add(node.left);
                }
                if (node.right != null) {
                    nodesQueue.add(node.right);
                }
            }

            // Switch the traversal direction for the next level
            leftToRight = !leftToRight;

            // Add the current level's values to the result list
            result.add(row);
        }

        // Return the final result of zigzag level order traversal
        return result;
    }
}

// Helper function to print the result
class Main {
    public static void printResult(List<List<Integer>> result) {
        for (List<Integer> row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        zigzagLevelOrder zigzagLevelOrder = new zigzagLevelOrder();

        // Get the zigzag level order traversal
        List<List<Integer>> result = zigzagLevelOrder.zigzagLevelOrder(root);

        // Print the result
        printResult(result);
    }
}
