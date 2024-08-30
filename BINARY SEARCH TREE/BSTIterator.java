import java.util.List;
import java.util.ArrayList;
import java.util.*;

// Definition for a binary tree node
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { data = val; left = null; right = null; }
}

class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    
    // Constructor initializes the iterator on the root of the BST
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    // Returns true if there is a next element in the iterator
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Returns the next smallest element in the BST
    public int next() {
        TreeNode temp = stack.pop();
        pushAll(temp.right);
        return temp.data;
    }

    // Helper function to push all the left nodes onto the stack
    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator iterator = new BSTIterator(root);
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
