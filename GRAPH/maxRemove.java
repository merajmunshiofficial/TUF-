import java.util.List;
import java.util.ArrayList;
import java.util.*;

class DisjointSet {
    /* To store the ranks, parents and 
    sizes of different set of vertices */
    int[] rank, parent, size;

    // Constructor
    DisjointSet(int n) {
        rank = new int[n + 1];
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // Function to find ultimate parent
    int findUPar(int node) {
        if (node == parent[node])
            return node;
        return parent[node] = findUPar(parent[node]);
    }

    // Function to implement union by rank
    void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
        }
        else if (rank[ulp_v] < rank[ulp_u]) {
            parent[ulp_v] = ulp_u;
        }
        else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }

    // Function to implement union by size
    void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }
        else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}


// maxRemove class
class maxRemove {
    // Function to remove maximum stones
    public int maxRemove(int[][] stones, int n) {
        
        /* To store the maximum row 
        and column having a stone */
        int maxRow = 0;
        int maxCol = 0;

        // Iterate on all the nodes
        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        // Disjoint Set data structure
        DisjointSet ds = 
            new DisjointSet(maxRow + maxCol + 1);

        // To store the nodes having a stone in Disjoint Set
        Map<Integer, Integer> stoneNodes = new HashMap<>();

        // Iterate on all stones
        for (int[] stone : stones) {
            // Row number
            int nodeRow = stone[0];

            // Converted column number
            int nodeCol = stone[1] + maxRow + 1;

            // United two nodes
            ds.unionBySize(nodeRow, nodeCol);

            // Add the nodes to the map
            stoneNodes.put(nodeRow, 1);
            stoneNodes.put(nodeCol, 1);
        }

        // To store the number of connected components
        int k = 0;

        // Iterate on the set
        for (int key : stoneNodes.keySet()) {
            /* Increment the count if 
            a new component is found */
            if (ds.findUPar(key) == key) {
                k++;
            }
        }

        // Return the answer
        return n - k;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] stones = {
            {0, 0}, {0, 1}, {1, 0},
            {1, 2}, {2, 1}, {2, 2}
        };

        // Creating instance of maxRemove class
        maxRemove sol = new maxRemove();

        /* Function call to get the 
        size of the largest island */
        int ans = sol.maxRemove(stones, n);

        // Output
        System.out.println("The size of the largest island is: " + ans);
    }
}
