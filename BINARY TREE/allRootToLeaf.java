import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node.
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

class allRootToLeaf {
    public List<List<Integer>> allRootToLeaf(TreeNode root) {
        // List to store all root-to-leaf paths
        List<List<Integer>> allPaths = new ArrayList<>();
        // List to store the current path
        List<Integer> currentPath = new ArrayList<>();
        
        // Helper function to perform DFS
        dfs(root, currentPath, allPaths);
        
        return allPaths;
    }

    private void dfs(TreeNode node, List<Integer> path, List<List<Integer>> allPaths) {
        if (node == null) {
            return; // Base case: return if the current node is null
        }

        path.add(node.data); // Add the current node's data to the path

        if (node.left == null && node.right == null) {
        // Add the path to allPaths if it's a leaf node
            allPaths.add(new ArrayList<>(path)); 
        } else {
            // Recursively call the function on the left child
            dfs(node.left, path, allPaths); 
            // Recursively call the function on the right child
            dfs(node.right, path, allPaths); 
        }
        // Backtrack by removing the last node from the path
        path.remove(path.size() - 1); 
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        allRootToLeaf allRootToLeaf = new allRootToLeaf();
        System.out.println(allRootToLeaf.allRootToLeaf(root));
    }
}
