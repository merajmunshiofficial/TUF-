import java.util.List;
import java.util.ArrayList;
import java.util.*;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { data = val; left = null; right = null; }
}

class distanceK {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Step 1: Create a map to store the parent of each node
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // If the left child exists, map its parent and push it into the queue
            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.add(node.left);
            }
            // If the right child exists, map its parent and push it into the queue
            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.add(node.right);
            }
        }

        // Step 2: Use BFS to find all nodes at distance k from the target
        List<Integer> result = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(target);
        visited.add(target);
        int currentDistance = 0;

        // Continue BFS until the desired distance is reached
        while (!queue.isEmpty()) {
            if (currentDistance == k) {
                // Collect all nodes at distance k
                while (!queue.isEmpty()) {
                    result.add(queue.poll().data);
                }
                return result;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // Check left child
                if (node.left != null && !visited.contains(node.left)) {
                    queue.add(node.left);
                    visited.add(node.left);
                }
                // Check right child
                if (node.right != null && !visited.contains(node.right)) {
                    queue.add(node.right);
                    visited.add(node.right);
                }
                // Check parent
                if (parentMap.containsKey(node) && !visited.contains(parentMap.get(node))) {
                    queue.add(parentMap.get(node));
                    visited.add(parentMap.get(node));
                }
            }
            currentDistance++;
        }

        return result;
    }

    // Helper function to create a binary tree from a list
    public static TreeNode createTree(List<Integer> nodes, int index) {
        if (index < nodes.size() && nodes.get(index) != null) {
            TreeNode root = new TreeNode(nodes.get(index));
            root.left = createTree(nodes, 2 * index + 1);
            root.right = createTree(nodes, 2 * index + 2);
            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        List<Integer> nodes = Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        TreeNode root = createTree(nodes, 0);
        TreeNode target = root.left;  // Node with value 5
        int k = 2;

        distanceK sol = new distanceK();
        List<Integer> result = sol.distanceK(root, target, k);

        System.out.println("Nodes at distance " + k + " from target node are: " + result);
    }
}
