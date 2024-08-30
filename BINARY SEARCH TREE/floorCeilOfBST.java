import java.util.List;
import java.util.ArrayList;
import java.util.*;


class TreeNode {
    int data;
    TreeNode left, right;
    TreeNode(int val) {
        data = val;
        left = right = null;
    }
}

class floorCeilOfBST {
    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
        // Initialize floor and ceil values to -1, indicating not found
        int floor = -1;
        int ceil = -1;

        // Find the floor value

		// Start from the root of the BST
        TreeNode current = root;  
        while (current != null) {
			// If the key matches the current node's value
            if (current.data == key) {
				// Set floor to this value  
                floor = current.data;  
                break; 
            /* If the key is greater than the current node's value
               Update floor to the current node's value 
               If the key is smaller than the current node's value
               Move to the left subtree to find a smaller value    */    
            } else if (current.data < key) {   
                floor = current.data;   
                current = current.right;  
            } else {  
                current = current.left;   
            }
        }

        // Find the ceil value

		// Reset current to start from the root again
        current = root;  
        while (current != null) {
			// If the key matches the current node's value
            if (current.data == key) {  
				// Set ceil to this value
                ceil = current.data;  
                break;

            /* If the key is smaller than the current node's value
             Update ceil to the current node's value 
             If the key is greater than the current node's value
             Move to the right subtree to find a larger value */ 
                  
            } else if (current.data > key) {  
                ceil = current.data;  
                current = current.left;  
            } else {  
                current = current.right;  
            }
        }

        // Return floor and ceil values as a list
        return Arrays.asList(floor, ceil);
    }

    public static void main(String[] args) {
        // Creating a sample BST
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);

        floorCeilOfBST sol = new floorCeilOfBST();
        int key = 11;  // Key to find floor and ceil for

        // Find and print floor and ceil values
        List<Integer> result = sol.floorCeilOfBST(root, key);
        System.out.println("Floor: " + result.get(0) + ", Ceil: " + result.get(1));
    }
}
