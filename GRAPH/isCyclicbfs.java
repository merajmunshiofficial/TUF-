import java.util.*;

class Solution {
    
    /* Function to return the topological
     sorting of given graph */
    private List<Integer> topoSort(int V, 
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

    public boolean isCyclic(int V, List<Integer> adj[]) {
        // To store the topological ordering
        List<Integer> topo = topoSort(V, adj);
        
        /* If topological sort doesn't include all
         nodes, the graph is cyclic in nature */
        if(topo.size() < V) return true;
        
        // Else the graph is acyclic
        return false;
    }

    public static void main(String[] args) {
        int V = 6;
        List<Integer>[] adj = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        
        adj[0].add(1);
        adj[1].add(2);
        adj[1].add(5);
        adj[2].add(3);
        adj[3].add(4);
        adj[4].add(1);
        
        // Creating an instance of Solution class
        Solution sol = new Solution();
        
        /* Function call to determine if cycle
         exists in given directed graph */
        boolean ans = sol.isCyclic(V, adj);
        
        // Output
        if(ans)
            System.out.println("The given directed graph contains a cycle.");
        else 
            System.out.println("The given directed graph does not contain a cycle.");
    }
}
