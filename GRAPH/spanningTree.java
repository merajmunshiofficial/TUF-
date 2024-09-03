import java.util.*;

public class Solution {

    // Function to get the sum of weights of edges in MST
    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        
        // Min-Heap to store pair of {edge, node}
        PriorityQueue<int[]> pq = 
            new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        
        // Visited array
        boolean[] visited = new boolean[V];
        
        // Push any arbitrary initial node
        pq.add(new int[]{0, 0});
        
        // To store the weight of MST
        int sum = 0;
        
        // Until the priority queue is not empty
        while (!pq.isEmpty()) {
            
            // Get the pair with minimum edge
            int[] p = pq.poll();
            
            int node = p[1]; // Get the node
            int wt = p[0]; // Get the edge weight
            
            /* If the node is already visited, 
            skip the iteration */
            if (visited[node]) continue;
            
            // Otherwise, mark the node as visited
            visited[node] = true;
            
            // Update the weight of MST
            sum += wt;
            
            // Traverse all the edges of the node
            for (List<Integer> it : adj.get(node)) {
                
                // Get the adjacent node
                int adjNode = it.get(0);
                
                // Get the edge weight
                int edgeWt = it.get(1);
                
                /* Add the pair to min-heap if 
                the node is not visited already */
                if (!visited[adjNode]) {
                    pq.add(new int[]{edgeWt, adjNode});
                }
            }
        }
        
        // Return the weight of MST
        return sum;
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> edges = Arrays.asList(
            Arrays.asList(0, 1, 1),
            Arrays.asList(1, 2, 2),
            Arrays.asList(2, 3, 3),
            Arrays.asList(0, 3, 4)
        );
        
        // Forming the adjacency list from edges
        List<List<List<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            
            adj.get(u).add(Arrays.asList(v, wt));
            adj.get(v).add(Arrays.asList(u, wt));
        }
        
        // Creating instance of Solution class
        Solution sol = new Solution();
        
        /* Function call to get the sum 
        of weights of edges in MST */
        int ans = sol.spanningTree(V, adj);
        
        System.out.println("The sum of weights of edges in MST is: " + ans);
    }
}
