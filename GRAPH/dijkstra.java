import java.util.List;
import java.util.ArrayList;
import java.util.*;

class dijkstra {
    
    /* Function to find the shortest distance of
    all the vertices from the source vertex S. */
    public int[] dijkstra(int V, 
        ArrayList<ArrayList<ArrayList<Integer>>> adj, 
        int S) {
            
        // TreeSet to store {dist, node}
        TreeSet<int[]> st = 
        new TreeSet<>(Comparator.comparingInt(a -> a[0]));
        
        // Distance array 
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        // Distance of source node from itself is 0
        dist[S] = 0;
        
        // Adding the source node to set
        st.add(new int[]{0, S});
        
        // Until the set is empty
        while (!st.isEmpty()) {
            // Get the distance
            int[] top = st.pollFirst();
            int dis = top[0];
            
            // Get the node
            int node = top[1];
            
            // Traverse all its neighbors
            for (ArrayList<Integer> it : adj.get(node)) {
                int adjNode = it.get(0); // node
                int edgeWt = it.get(1); // edge weight
                
                /* If the tentative distance to 
                reach adjacent node is smaller 
                than the known distance */
                if (dis + edgeWt < dist[adjNode]) {
                    
                    /* If another longer known distance 
                    is found, erase it from the set */
                    if (dist[adjNode] != Integer.MAX_VALUE)
                        st.remove(new int[]{dist[adjNode], adjNode});
                    
                    // Update the known distance
                    dist[adjNode] = dis + edgeWt;
                    
                    // Add the new pair to the set
                    st.add(new int[]{dist[adjNode], adjNode});
                }
            }
        }
        
        // Return the result
        return dist;
    }

    public static void main(String[] args) {
        int V = 2, S = 0;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        
        adj.add(new ArrayList<>(List.of(new ArrayList<>(List.of(1, 9)))));
        adj.add(new ArrayList<>(List.of(new ArrayList<>(List.of(0, 9)))));
        
        /* Creating an instance of 
        dijkstra class */
        dijkstra sol = new dijkstra();
        
        /* Function call to find the shortest distance 
        of each node from the source node */
        int[] ans = sol.dijkstra(V, adj, S);
        
        // Output
        System.out.println("The shortest distance of nodes from the source node is: ");
        for (int i = 0; i < V; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
