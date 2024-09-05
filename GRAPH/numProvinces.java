import java.util.List;
import java.util.ArrayList;
import java.util.*;

class numProvinces {
    // Function for BFS traversal
    private void bfs(int node, List<Integer> adjLs[], boolean[] vis) {
        
        // Mark the node as visited
        vis[node] = true;
        
        // Queue required for BFS traversal
        Queue<Integer> q = new LinkedList<>();
        
        // To start traversal from node
        q.add(node); 
        
        /* Keep on traversing till 
        the queue is not empty */
        while (!q.isEmpty()) {
            // Get the node
            int i = q.poll();
            
            // Traverse its unvisited neighbours
            for (int adjNodes : adjLs[i]) {
                
                if (!vis[adjNodes]) {
                    
                    // Mark the node as visited
                    vis[adjNodes] = true;
                    
                    // Add the node to queue
                    q.add(adjNodes);
                }
            }
        }
    }

    // Function for DFS traversal  
    private void dfs(int node, List<Integer> adjLs[], boolean[] vis) {
        
        // Mark the node as visited
        vis[node] = true; 
        
        // Traverse its unvisited neighbours
        for (int it : adjLs[node]) {
            
            if (!vis[it]) {
                // Recursively perform DFS
                dfs(it, adjLs, vis); 
            }
        }
    }
    
    /* Function to find the number of
     provinces in the given graph */
    public int numProvinces(int[][] adj) {
        
        // Variable to store number of nodes
        int V = adj.length;
        
        // To store adjacency list
        List<Integer>[] adjLs = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjLs[i] = new ArrayList<>();
        }
        
        // Convert adjacency matrix to adjacency list
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                // self nodes are not considered
                if (adj[i][j] == 1 && i != j) {
                    adjLs[i].add(j); 
                    adjLs[j].add(i); 
                }
            }
        }
        
        // Visited array
        boolean[] vis = new boolean[V];
        
        // Variable to store number of provinces
        int cnt = 0; 
        
        // Start Traversal
        for (int i = 0; i < V; i++) {
            // If the node is not visited
            if (!vis[i]) {
                // Increment counter
                cnt++;
                
                // Start traversal from current node
                bfs(i, adjLs, vis); 
                //dfs(i, adjLs, vis);
            }
        }
        
        // Return the count
        return cnt; 
    }
    
    public static void main(String[] args) {
        int[][] adj = {
            {1, 0, 0, 1},
            {0, 1, 1, 0},
            {0, 1, 1, 0},
            {1, 0, 0, 1}
        };
        
        /* Creating an instance of 
        numProvinces class */
        numProvinces sol = new numProvinces();
        
        /* Function call to find the 
        provinces in the given graph */
        int ans = sol.numProvinces(adj);
        
        System.out.println("The number of provinces in the given graph is: " + ans);
    }
}
