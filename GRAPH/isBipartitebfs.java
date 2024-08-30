import java.util.*;

class Solution {

    /* Function to perform BFS traversal and color
    the nodes with alternate colors in a component */
    private boolean bfs(int start, int V, List<Integer>[] adj, 
                        int[] color) {
        // Queue for BFS traversal
        Queue<Integer> q = new LinkedList<>();
        
        // Add initial node to queue
        q.add(start);
        color[start] = 0; // Mark it with a color
        
        // While queue is not empty
        while (!q.isEmpty()) {
            // Get the node
            int node = q.poll();
            
            // Traverse all its neighbors
            for (int it : adj[node]) {
                
                // If not already colored
                if (color[it] == -1) {
                    
                    // Color it with opposite color.
                    color[it] = 1 - color[node];
                    
                    // Push the node in queue
                    q.add(it);
                }
                
                // Else if the neighbor has same color as node
                else if (color[it] == color[node]) {
                    
                    /* Return false, as the 
                    component is not bipartite */
                    return false;
                }
            }
        }
        
        // Return true if the component is bipartite
        return true;
    }

    /* Function to check if the 
    given graph is bipartite */
    public boolean isBipartite(int V, List<Integer>[] adj) {
        
        /* To store the color of nodes, where 
        each node is uncolored initially */
        int[] color = new int[V];
        Arrays.fill(color, -1);
        
        // Traverse all the nodes 
        for (int i = 0; i < V; i++) {
            
            // If not colored, start the traversal
            if (color[i] == -1) {
                // Return false if graph is not bipartite
                if (!bfs(i, V, adj, color))
                    return false;
            }
        }
        
        /* Return true if each 
        component is bipartite */
        return true;
    }

    public static void main(String[] args) {
        int V = 4;
        List<Integer>[] adj = new List[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].addAll(Arrays.asList(1, 3));
        adj[1].addAll(Arrays.asList(0, 2));
        adj[2].addAll(Arrays.asList(1, 3));
        adj[3].addAll(Arrays.asList(0, 2));

        /* Creating an instance of 
        Solution class */
        Solution sol = new Solution(); 
        
        /* Function call to check 
        if the given graph is bipartite */
        boolean ans = sol.isBipartite(V, adj);
        
        // Output
        if (ans) 
            System.out.println("The given graph is a bipartite graph.");
        else 
            System.out.println("The given graph is not a bipartite graph.");
    }
}
