import java.util.List;
import java.util.ArrayList;
import java.util.*;

class isCycledfs {
    
    // Function to perform DFS traversal
    private boolean dfs(int i, List<Integer> adj[], 
                        boolean[] visited, int prev) {
        // Mark the node as visited
        visited[i] = true;
        
        // Traverse all the neighbors
        for (int node : adj[i]) {
            
            // If not visited
            if (!visited[node]) {
                
                /* Recursively perform DFS, and 
                return true if cycle is found */
                if (dfs(node, adj, visited, i)) {
                    return true;
                }
            }
            
            /* Else if it is visited with some 
            different parent a cycle is detected */
            else if (node != prev) {
                return true;
            }
        }
        
        // Return false if no cycle is detected
        return false;
    }

    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, List<Integer> adj[]) {
        
        // Visited array
        boolean[] visited = new boolean[V];
        
        // Start Traversal from every unvisited node
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                /* Start DFS traversal, and 
                return true if cycle is found */
                if (dfs(i, adj, visited, -1)) {
                    return true;
                }
            }
        }
        
        // Return false if no cycle is detected
        return false;
    }

    public static void main(String[] args) {
        int V = 6;
        List<Integer> adj[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].addAll(Arrays.asList(1, 3));
        adj[1].addAll(Arrays.asList(0, 2, 4));
        adj[2].addAll(Arrays.asList(1, 5));
        adj[3].addAll(Arrays.asList(0, 4));
        adj[4].addAll(Arrays.asList(1, 3, 5));
        adj[5].addAll(Arrays.asList(2, 4));
        
        /* Creating an instance of 
        isCycledfs class */
        isCycledfs sol = new isCycledfs();
        
        /* Function call to detect 
        cycle in given graph. */
        boolean ans = sol.isCycle(V, adj);
        
        // Output
        if (ans) 
            System.out.println("The given graph contains a cycle.");
        else 
            System.out.println("The given graph does not contain a cycle.");
    }
}
