import java.util.List;
import java.util.ArrayList;
import java.util.*;

class DisjointSet {
   // To store the rank of each node
   private int[] rank;

   /* To store the size of components 
   that each node belongs to */
   private int[] size;

   // To store the ultimate parent of each node
   private int[] parent;

   // Constructor
   public DisjointSet(int n) {
       // Resize the arrays
       rank = new int[n + 1];
       parent = new int[n + 1];
       size = new int[n + 1];
       Arrays.fill(size, 1);

       // Initialise each node with its own value
       for (int i = 0; i <= n; i++) {
           parent[i] = i;
       }
   }

   /* Helper function to find ultimate
   parent along with path compression */
   public int findUPar(int node) {
       // Base case
       if (node == parent[node])
           return node;

       // Backtracking step for path compression
       return parent[node] = findUPar(parent[node]);
   }

   /* Function to determine if two nodes 
   are in the same component or not */
   public boolean find(int u, int v) {
       // Return true if both have same ultimate parent 
       return (findUPar(u) == findUPar(v));
   }

   /* Function to perform union of 
   two nodes based on ranks */
   public void unionByRank(int u, int v) {
       // Get the ultimate parents of both nodes
       int ulp_u = findUPar(u);
       int ulp_v = findUPar(v);

       // Return if nodes already belong to the same component
       if (ulp_u == ulp_v) return;

       /* Otherwise, join the node to the other 
       node having higher ranks among the two */
       if (rank[ulp_u] < rank[ulp_v]) {
           // Update the parent
           parent[ulp_u] = ulp_v;
       } else if (rank[ulp_v] < rank[ulp_u]) {
           // Update the parent
           parent[ulp_v] = ulp_u;
       } 
       /* If both have same rank, join any node to the 
       other and increment the rank of the parent node */
       else {
           // Update the parent
           parent[ulp_v] = ulp_u;
           // Update the rank
           rank[ulp_u]++;
       }
   }

   /* Function to perform union of 
   two nodes based on sizes */
   public void unionBySize(int u, int v) {
       // Get the ultimate parents of both nodes
       int ulp_u = findUPar(u);
       int ulp_v = findUPar(v);

       // Return if nodes already belong to the same component
       if (ulp_u == ulp_v) return;

       /* Otherwise, join the node belonging to the smaller 
       component to the node belonging to bigger component */
       if (size[ulp_u] < size[ulp_v]) {
           // Update the parent
           parent[ulp_u] = ulp_v;
           // Update the size 
           size[ulp_v] += size[ulp_u];
       } else {
           // Update the parent
           parent[ulp_v] = ulp_u;
           // Update the size
           size[ulp_u] += size[ulp_v];
       }
   }

   public static void main(String[] args) {
    // Disjoint Data structure
    DisjointSet ds = new DisjointSet(7);
    ds.unionBySize(1, 2); // Adding edge between 1 and 2
    ds.unionBySize(2, 3); // Adding edge between 2 and 3
    ds.unionBySize(4, 5); // Adding edge between 4 and 5
    ds.unionBySize(6, 7); // Adding edge between 6 and 7
    ds.unionBySize(5, 6); // Adding edge between 5 and 6

    /* Checking if node 3 and node 7 
    are in the same component */
    if (ds.find(3, 7))
        System.out.println("They belong to the same components.");
    else
        System.out.println("They do not belong to the same components.");

    ds.unionBySize(3, 7); // Adding edge between 3 and 7

    /* Checking again if node 3 and node 7 
    are in the same component */
    if (ds.find(3, 7))
        System.out.println("They belong to the same components.");
    else
        System.out.println("They do not belong to the same components.");
}

}

