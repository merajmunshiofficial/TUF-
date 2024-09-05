import java.util.List;
import java.util.ArrayList;
import java.util.*;

public class shortestPathII {

    // Function to perform BFS traversal
    private void bfs(int src, List<Integer>[] adj, 
                     int[] dist) {
        
        // Distance of source node from itself is zero
        dist[src] = 0; 
        
        // Queue to facilitate BFS traversal
        Queue<Integer> q = new LinkedList<>();
        
        // Adding source node to queue
        q.add(src); 
        
        // Until the queue is empty
        while (!q.isEmpty()) {
            
            // Get the node from queue
            int node = q.poll(); 
            
            // Traverse all its neighbors
            for (int adjNode : adj[node]) {
                
                // If a shorter distance is found
                if (dist[node] + 1 < dist[adjNode]) {
                    
                    // Update the distance
                    dist[adjNode] = 1 + dist[node]; 
                    
                    // Add the node to the queue
                    q.add(adjNode); 
                }
            }
        }
    }
    
    /* Function to get the shortest path 
    for every node from source node 0 */
    public int[] shortestPath(int[][] edges, int N, int M) {

        // To store the graph
        List<Integer>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        // Add edges to the graph
        for (int[] edge : edges) {
            int u = edge[0]; // first node
            int v = edge[1]; // second node
            
            // Add the edge
            adj[u].add(v);
            adj[v].add(u);
        }
        
        // Distance array to store the shortest paths
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        // Start the BFS traversal from source node
        bfs(0, adj, dist);
        
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
        
        int N = 9, M = 10;
        int[][] edges = {
            {0, 1}, {0, 3}, {3, 4}, 
            {4, 5}, {5, 6}, {1, 2}, 
            {2, 6}, {6, 7}, {7, 8}, {6, 8}
        };
        
        /* Creating an instance of 
        shortestPathII class */
        shortestPathII sol = new shortestPathII();
        
        /* Function call to determine shortest paths */
        int[] ans = sol.shortestPath(edges, N, M);
        
        // Output
        System.out.println("The shortest distance of every node from source node is:");
        for (int i = 0; i < N; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
