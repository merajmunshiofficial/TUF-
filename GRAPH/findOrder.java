import java.util.List;
import java.util.ArrayList;
import java.util.*;

class findOrder {
    
    /* Function to return the topological
     sorting of given graph */
    private int[] topoSort(int V, List<Integer>[] adj) {
        
        // To store the In-degrees of nodes
        int[] inDegree = new int[V];
        
        // Update the in-degrees of nodes
        for (int i = 0; i < V; i++) {
            
            for (int it : adj[i]) {
                // Update the in-degree
                inDegree[it]++;
            }
        }
        
        // To store the result
        int[] ans = new int[V];
        int idx = 0;
        
        // Queue to facilitate BFS
        Queue<Integer> q = new LinkedList<>();
        
        // Add the nodes with no in-degree to queue
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) q.add(i);
        }
        
        // Until the queue is empty
        while (!q.isEmpty()) {
            
            // Get the node
            int node = q.poll();
            
            // Add it to the answer
            ans[idx++] = node;
            
            // Traverse the neighbours
            for (int it : adj[node]) {
                
                // Decrement the in-degree
                inDegree[it]--;
                
                /* Add the node to queue if 
                its in-degree becomes zero */
                if (inDegree[it] == 0) q.add(it);
            }
        }
        
        // Return the result
        return Arrays.copyOfRange(ans, 0, idx);
    }
    
    /* Function to determine order
    of tasks to finish all tasks */
    public int[] findOrder(int N, int[][] arr) {
        
        // To store the graph
        List<Integer>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();
        
        // Form the graph
        for (int[] it : arr) {
            int u = it[0];
            int v = it[1];
            
            // Add the edge v-> u
            adj[v].add(u);
        }
        
        // Get the topological ordering of graph
        int[] topo = topoSort(N, adj);
        
        /* If it doesn't contain all nodes,
        it is impossible to finish all tasks */
        if (topo.length < N) return new int[0];
        
        // Return the ordering otherwise
        return topo;
    }
    
    public static void main(String[] args) {
        
        int N = 4;
        int[][] arr = {
            {1, 0},
            {2, 1},
            {3, 2}
        };
        
        /* Creating an instance of 
        findOrder class */
        findOrder sol = new findOrder();
        
        /* Function call to determine order
	    of tasks to finish all tasks */
        int[] ans = sol.findOrder(N, arr);
        
        // Output
        System.out.println("The order to perform tasks is:");
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
