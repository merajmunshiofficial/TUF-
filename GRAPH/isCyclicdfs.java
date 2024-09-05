import java.util.List;
import java.util.ArrayList;
import java.util.*;

class isCyclicdfs {
    
    // Function to perform DFS traversal
    private boolean dfs(int node, List<Integer> adj[], 
                        boolean[] visited, 
                        boolean[] pathVisited) {
        
        // Mark the node as path visited
        visited[node] = true;
        
        // Mark the node as path visited
        pathVisited[node] = true;
        
        // Traverse all the neighbors
        for(int it : adj[node]) {
            
            /* If the neighbor is already visited 
            in the path, a cycle is detected */
            if(pathVisited[it]) 
                return true;
            
            /* Else if the node is unvisited, 
            perform DFS recursively from this node */
            else if(!visited[it]) {
                
                // If cycle is detected, return true
                if(dfs(it, adj, visited, pathVisited)) 
                    return true;
            }
        }
        
        // Remove the node from path 
        pathVisited[node] = false;
        
        // Return false if no cycle is detected
        return false;
    }
    
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, List<Integer> adj[]) {
        
        // Visited array
        boolean[] visited = new boolean[V];
        
        /* Array to mark nodes that are 
        visited in a particular path */
        boolean[] pathVisited = new boolean[V];
        
        // Traverse the graph
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                
                // If a cycle is found, return true
                if(dfs(i, adj, visited, pathVisited)) 
                    return true;
            }
        }
        
        /* Return false if no cycle is 
        detected in any component */
        return false;
    }

    public static void main(String[] args) {
        
        int V = 6;
        List<Integer> adj[] = new List[V];
        for(int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        
        adj[0].add(1); 
        adj[1].add(2); adj[1].add(5);
        adj[2].add(3);
        adj[3].add(4);
        adj[4].add(1);
        
        /* Creating an instance of 
        isCyclicdfs class */
        isCyclicdfs sol = new isCyclicdfs(); 
        
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

