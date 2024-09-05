import java.util.List;
import java.util.ArrayList;
import java.util.*;

class topoSortKhanAlgo {
    /* Function to return the topological
     sorting of given graph */
    public List<Integer> topoSort(int V, 
                  List<Integer> adj[]) {
        
        // To store the result
        List<Integer> ans = new ArrayList<>();
        
        // To store the In-degrees of nodes
        int[] inDegree = new int[V];
        
        // Calculating the In-degree of the given graph
        for(int i = 0; i < V; i++) {
            for(int it : adj[i]) inDegree[it]++;
        }
        
        // Queue to facilitate BFS
        Queue<Integer> q = new LinkedList<>();
        
        // Add the nodes with no in-degree to queue
        for(int i = 0; i < V; i++) {
            if(inDegree[i] == 0) q.add(i);
        }
        
        // Until the queue is empty
        while(!q.isEmpty()) {
            
            // Get the node
            int node = q.poll();
            
            // Add it to the answer
            ans.add(node);
            
            // Traverse the neighbours
            for(int it : adj[node]) {
                
                // Decrement the in-degree
                inDegree[it]--;
                
                /* Add the node to queue if 
                its in-degree becomes zero */
                if(inDegree[it] == 0) q.add(it);
            }
        }
        
        // Return the result
        return ans;
    }

    public static void main(String[] args) {
        
        int V = 6;
        List<Integer> adj[] = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[2].add(3);
        adj[3].add(1);
        adj[4].add(0);
        adj[4].add(1);
        adj[5].add(0);
        adj[5].add(2);
        
        /* Creating an instance of 
        topoSortKhanAlgo class */
        topoSortKhanAlgo sol = new topoSortKhanAlgo(); 
        
        /* Function call to return the 
        topological sorting of given graph */
        List<Integer> ans = sol.topoSort(V, adj);
        
        // Output
        System.out.println("The topological sorting of the given graph is:");
        for(int i = 0; i < V; i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
