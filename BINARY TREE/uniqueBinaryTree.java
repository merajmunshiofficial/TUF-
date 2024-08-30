class uniqueBinaryTree {
    // Method to check if a unique binary tree can be constructed
    public boolean uniqueBinaryTree(int a, int b) {
        // Return false if both traversals are the same 
       // or if they are preorder and postorder
        return !(a == b || (a == 1 && b == 3) || (a == 3 && b == 1));
    }

    public static void main(String[] args) {
        uniqueBinaryTree uniqueBinaryTree = new uniqueBinaryTree();
        // Example test cases
        System.out.println(uniqueBinaryTree.uniqueBinaryTree(1, 2)); 
        System.out.println(uniqueBinaryTree.uniqueBinaryTree(1, 3)); 
    }
}
