import java.util.List;
import java.util.ArrayList;
import java.util.*;

class DisjointSet {
    /* To store the ranks, parents and 
    sizes of different set of vertices */
    List<Integer> rank, parent, size;

    // Constructor
    DisjointSet(int n) {
        rank = new ArrayList<>(n + 1);
        Collections.fill(rank, 0);
        parent = new ArrayList<>(n + 1);
        size = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }
    
    // Function to find ultimate parent
    int findUPar(int node) {
        if (node == parent.get(node))
            return node;
        parent.set(node, findUPar(parent.get(node)));
        return parent.get(node);
    }
    
    // Function to implement union by rank
    void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        }
        else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        }
        else {
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u) + 1);
        }
    }
    
    // Function to implement union by size
    void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }
        else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

// disjointSet class
class disjointSet {
    // Function to get the number of provinces
    int numProvinces(int[][] adj, int V) {
        
        // Creating a disjoint set of V nodes
        DisjointSet ds = new DisjointSet(V);
        
        // Adding the edges to the disjoint set
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                
                // If node i and node j are connected
                if (adj[i][j] == 1) {
                    
                    // Joining them in disjoint set
                    ds.unionBySize(i, j);
                }
            }
        }
        
        // To store the number of provinces
        int count = 0;
        
        // Check for all the nodes
        for (int i = 0; i < V; i++) {
            
            /* Increment the count if a unique
            ultimate parent node is found */
            if (ds.findUPar(i) == i) 
                count++;
        }
        
        // Return the result
        return count;
    }
    
    public static void main(String[] args) {
        int V = 3;
        int[][] adj = {
            {1, 0, 1},
            {0, 1, 0},
            {1, 0, 1}
        };

        // Creating instance of disjointSet class
        disjointSet sol = new disjointSet();
        
        /* Function call to get the 
        number of provinces */
        int ans = sol.numProvinces(adj, V);
        
        System.out.println("The number of provinces in the given graph is: " + ans);
    }
}
