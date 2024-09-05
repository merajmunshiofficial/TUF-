import java.util.List;
import java.util.ArrayList;
import java.util.*;

class topoSortdfs {
    
    // Function to perform DFS traversal
    private void dfs(int node, List<Integer> adj[], 
                    List<Integer> vis, 
                    Stack<Integer> st) {
                        
        // Mark the node as visited
        vis.set(node, 1);
        
        // Traverse all the neighbors
        for(int it : adj[node]) {
            
            // If not visited, recursively perform DFS.
            if(vis.get(it) == 0) dfs(it, adj, vis, st);
        }
        
        /* Add the current node to stack 
        once all the nodes connected to it 
        have been processed */
        st.push(node);
    }

    /* Function to return list containing 
    vertices in Topological order */
    public List<Integer> topoSort(int V, List<Integer> adj[]) {
        
        // To store the result
        List<Integer> ans = new ArrayList<>();
        
        /* Stack to store processed 
        nodes in reverse order */
        Stack<Integer> st = new Stack<>();
        
        // Visited array
        List<Integer> vis = new ArrayList<>(Collections.nCopies(V, 0));
        
        // Traverse the graph
        for(int i = 0; i < V; i++) {
            
            // Start DFS traversal for unvisited node
            if(vis.get(i) == 0) {
                dfs(i, adj, vis, st);
            }
        }
        
        // Until the stack is empty
        while(!st.isEmpty()) {
            
            // Add the top of stack to result
            ans.add(st.pop());
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
        topoSortdfs class */
        topoSortdfs sol = new topoSortdfs(); 
        
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
