import java.util.*;

class Solution {
    
    /* Function to return the topological
     sorting of given graph */
    private int[] topoSort(int V, 
            List<Integer>[] adj) {
	    
        // To store the In-degrees of nodes
	    int[] inDegree = new int[V];
	    
	    // Update the in-degrees of nodes
		for (int i = 0; i < V; i++) {
		    
			for(int it : adj[i]) {
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
	    for(int i = 0; i < V; i++) {
	        if(inDegree[i] == 0) q.add(i);
	    }
	    
	    // Until the queue is empty
	    while(!q.isEmpty()) {
	        
	        // Get the node
	        int node = q.poll();
	        
	        // Add it to the answer
	        ans[idx++] = node;
	        
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
	    return Arrays.copyOfRange(ans, 0, idx);
    }
    
    /* Function to get the
	eventually safe nodes */
    public int[] eventualSafeNodes(int V, 
                            int[][] adj) {
	    
	    // To store the reverse graph
	    ArrayList<Integer>[] adjRev = new ArrayList[V];
	    for (int i = 0; i < V; i++) 
	        adjRev[i] = new ArrayList<>();
	    
	    // Reversing the edges
	    for (int i = 0; i < V; i++) {
		    
			// i -> it, it-> i
			for (int it : adj[i]) {
			    
			    // Add the edge to reversed graph
				adjRev[it].add(i);
			}
		}
		
	    /* Return the topological 
	    sort of the given graph */
	    int[] result = topoSort(V, adjRev);
	    
	    // Sort the result
	    Arrays.sort(result);
	    
	    // Return the result
	    return result;
	}

    public static void main(String[] args) {
        int V = 7;
        int[][] adj = {
            {1, 2},
            {2, 3},
            {5},
            {0},
            {5},
            {},
            {}
        };
        
        /* Creating an instance of 
        Solution class */
        Solution sol = new Solution();
        
        /* Function call to get the eventually 
        safe nodes in the given graph */
        int[] ans = sol.eventualSafeNodes(V, adj);
        
        // Output
        System.out.println("The eventually safe nodes in the graph are:");
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
