import java.util.List;
import java.util.ArrayList;
import java.util.*;

public class isBipartitedfs {
    
    /* Function to perform DFS traversal and 
    color the nodes with alternate colors*/
    private boolean dfs(int node, int col, int[] color, 
                        List<Integer> adj[]) {
                            
        // Color the current node
        color[node] = col;

        // Traverse adjacent nodes
        for(int it : adj[node]) {
            
            // if uncoloured
            if(color[it] == -1) {
                
                // Recursively color the nodes 
                if(dfs(it, 1 - col, color, adj) == false) 
                    return false; 
            }
            
            // if previously coloured and have the same colour
            else if(color[it] == col) {
                
                // Return false as it is not bipartite
                return false; 
            }
        }
        
        // Return true if all the nodes can 
        // be colored with alternate colors
        return true; 
    }

    // Function to check if the given graph is bipartite
    public boolean isBipartite(int V, List<Integer> adj[]) {
        
        // To store the color of nodes, where 
        // each node is uncolored initially
        int[] color = new int[V];
        Arrays.fill(color, -1);

        // Start Traversal of connected components
        for(int i = 0; i < V; i++) {
            
            // if a node is not colored, 
            // a new component is found
            
            if(color[i] == -1) {
                // Start DFS traversal 
                // and color each node
                
                if(dfs(i, 0, color, adj) == false) {
                    
                    // Return false if component 
                    // is found not to be bipartite
                    return false;
                }
            }
        }
        
        // Return true if each 
        // component is bipartite
        return true;
    }

    public static void main(String[] args) {
        int V = 4;
        List<Integer> adj[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].add(1);
        adj[0].add(3);
        adj[1].add(0);
        adj[1].add(2);
        adj[2].add(1);
        adj[2].add(3);
        adj[3].add(0);
        adj[3].add(2);

        // Creating an instance of isBipartitedfs class
        isBipartitedfs sol = new isBipartitedfs();

        // Function call to check if the given graph is bipartite
        boolean ans = sol.isBipartite(V, adj);

        // Output
        if(ans)
            System.out.println("The given graph is a bipartite graph.");
        else
            System.out.println("The given graph is not a bipartite graph.");
    }
}


