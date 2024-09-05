import java.util.List;
import java.util.ArrayList;
import java.util.*;

class shortestPath {
    
    // Function to perform DFS traversal
    private void topoSort(int node, List<int[]>[] adj, 
                          boolean[] vis, 
                          Stack<Integer> st) {
                
        // Mark the node as visited 
        vis[node] = true;
        
        // Traverse all the neighbors
        for (int[] it : adj[node]) {
            
            // Get the node
            int v = it[0];
            
            // If not visited, recursively perform DFS.
            if (!vis[v]) {
                topoSort(v, adj, vis, st);
            }
        }
        
        /* Add the current node to stack 
        once all the nodes connected to it 
        have been processed */
        st.push(node);
    }
    
    /* Function to get the shortest path 
    for every node from source node 0 */
    public int[] shortestPath(int N, int M, 
                            int[][] edges) {

        // To store the graph
        List<int[]>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        // Add edges to the graph
        for (int i = 0; i < M; i++) {
            int u = edges[i][0]; // node 1
            int v = edges[i][1]; // node 2
            int wt = edges[i][2]; // edge weight
            
            // Add the weighted edge 
            adj[u].add(new int[]{v, wt});
        }
        
        // Visited array
        boolean[] vis = new boolean[N];
        
        /* Stack to facilitate topological 
        sorting using DFS traversal */
        Stack<Integer> st = new Stack<>();
        
        // Get the topological ordering
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                topoSort(i, adj, vis, st);
            }
        }
        
        // Distance array to store the shortest paths
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        // Distance of source node to itself is zero
        dist[0] = 0;
        
        // Until the stack is not empty
        while (!st.isEmpty()) {
            
            // Get the node from top of stack
            int node = st.pop();
            
            // Update the distances of adjacent nodes
            for (int[] it : adj[node]) {
                int v = it[0]; // adjacent node
                int wt = it[1]; // edge weight
                
                /* Relaxing the edge, i.e., if a 
                shorter path is found, update its
                distance to new shorter distance*/
                if (dist[node] + wt < dist[v]) {
                    dist[v] = wt + dist[node];
                }
            }
        }
        
        /* If a node is unreachable, 
        updating its distance to -1 */
        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE) 
                dist[i] = -1;
        }
        
        // Return the result
        return dist;
    }

    public static void main(String[] args) {
        int N = 4, M = 2;
        int[][] edges = {
            {0, 1, 2}, {0, 2, 1}  
        };

        // Creating an instance of shortestPath class
        shortestPath sol = new shortestPath();
        
        /* Function call to determine order 
        of letters based on alien dictionary */
        int[] ans = sol.shortestPath(N, M, edges);
        
        // Output
        System.out.println("The shortest distance of every node from source node is:");
        for (int i = 0; i < N; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
