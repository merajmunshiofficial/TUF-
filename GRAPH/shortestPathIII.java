import java.util.List;
import java.util.ArrayList;
import java.util.*;

public class shortestPathIII {
    /* Function to find the shortest 
    path from node 1 to node n */
    public List<Integer> shortestPath(int n, int m, int[][] edges) {
        
        // Adjacency list to store graph
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Adding the edges to the graph
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        
        /* Using priority queue to 
        implement Dijkstra Algorithm */
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        
        // Distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        // Parent array
        int[] parent = new int[n + 1];
        
        /* Marking each node as 
        its own parent initially */
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        /* Distance of source node 
        (node 1) to itself is zero */
        dist[1] = 0;
        
        // Push the source node to the queue.
        pq.add(new int[]{0, 1});
        
        // Until the queue is empty
        while (!pq.isEmpty()) {
            /* Get the pair containing node having 
            minimum distance from source node */
            int[] curr = pq.poll();
            
            int node = curr[1]; // node
            int dis = curr[0]; // distance
            
            // Iterate through the neighbors
            for (int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0]; // node
                int edWt = neighbor[1]; // edge weight
                
                /* If the tentative distance to 
                reach adjacent node is smaller 
                than the known distance */
                if (dis + edWt < dist[adjNode]) {
                    
                    // Update the known distance
                    dist[adjNode] = dis + edWt;
                    
                    // Push the new pair to priority queue
                    pq.add(new int[]{dis + edWt, adjNode});
                    
                    /* Update the parent of the adjNode 
                    to the recent node(where it came from) */
                    parent[adjNode] = node;
                }
            }
        }
        
        /* If distance to the node could not be found, 
        return an array containing -1. */
        if (dist[n] == Integer.MAX_VALUE) {
            return Arrays.asList(-1);
        }
        
        // Array to store the path
        List<Integer> path = new ArrayList<>();
        
        // Start from the destination node
        int node = n;
        
        /* Iterate backwards from destination 
        to source through the parent array */
        while (parent[node] != node) {
            
            // Add the node to the path
            path.add(node); 
            
            // Take a step back
            node = parent[node];
        }
        
        // Add the source node to the path
        path.add(1);
        
        /* Since the path stored is in a 
        reverse order, reverse the array 
        to get the actual path */
        Collections.reverse(path);
        
        // Add the path weight in the beginning
        path.add(0, dist[n]);
        
        // Return the result
        return path;
    }

    public static void main(String[] args) {
        int n = 5, m = 6;
        int[][] edges = {
            {1, 2, 2}, {2, 5, 5}, {2, 3, 4}, 
            {1, 4, 1}, {4, 3, 3}, {3, 5, 1}
        };
        
        /* Creating an instance of 
        shortestPathIII class */
        shortestPathIII sol = new shortestPathIII();
        
        /* Function call to find the shortest distance 
        of each node from the source node */
        List<Integer> ans = sol.shortestPath(n, m, edges);
        
        // Output
        System.out.println("The resulting path weight is: " + ans.get(0));
        System.out.println("The path is: ");
        for (int i = 1; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
