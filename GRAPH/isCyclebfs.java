import java.util.List;
import java.util.ArrayList;
import java.util.*;

class isCyclebfs {
    
    // Function to perform BFS traversal
    private boolean bfs(int i, 
        List<Integer> adj[], 
        boolean[] visited) {
            
        // Queue to store {node, parent}
        Queue<int[]> q = new LinkedList<>();
        
        /* Push initial node in queue 
        with no one as parent */
        q.add(new int[]{i, -1});
        
        // Mark the node as visited
        visited[i] = true;
        
        // Until the queue is empty
        while (!q.isEmpty()) {
            
            // Get the node and its parent
            int[] current = q.poll();
            int node = current[0];
            int parent = current[1];
            
            // Traverse all the neighbors
            for (int it : adj[node]) {
                
                // If not visited
                if (!visited[it]) {
                    // Mark the node as visited
                    visited[it] = true;
                    
                    /* Push the new node in queue 
                    with curr node as parent */
                    q.add(new int[]{it, node});
                } 
                
                /* Else if it is visited with some 
                different parent a cycle is detected */
                else if (it != parent) return true;
            }
        }
        return false;
    }

    /* Function to detect cycle 
    in an undirected graph. */
    public boolean isCycle(int V, 
            List<Integer> adj[]) {
                
        // Visited array 
        boolean[] visited = new boolean[V];
        
        /* Variable to store if 
        there is a cycle detected */
        boolean ans = false;
        
        // Start Traversal from every unvisited node
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                
                // Start BFS traversal and update result
                ans = bfs(i, adj, visited);
                
                // Break if a cycle is detected
                if (ans) break;
            }
        }
        return ans;
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
        
        // Creating an instance of isCyclebfs class
        isCyclebfs sol = new isCyclebfs();
        
        // Function call to detect cycle in given graph.
        boolean ans = sol.isCycle(V, adj);
        
        // Output
        if (ans)
            System.out.println("The given graph contains a cycle.");
        else
            System.out.println("The given graph does not contain a cycle.");
    }
}

