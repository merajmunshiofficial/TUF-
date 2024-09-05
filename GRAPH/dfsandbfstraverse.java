import java.util.List;
import java.util.ArrayList;
import java.util.*;

class dfsandbfstraverse {

    /* Helper function to perform BFS
    traversal from the node */
    private void bfs(int node, List<Integer>[] adj, boolean[] vis, 
                     List<Integer> ans) {

        // Queue data structure
        Queue<Integer> q = new LinkedList<>();

        // Push the starting node
        q.add(node);

        // Until the queue is empty
        while (!q.isEmpty()) {
            // Get the node
            int current = q.poll();

            // Add the node to answer
            ans.add(current);

            // Traverse for all its neighbours
            for (int it : adj[current]) {
                /* If the neighbour has previously not been
                visited, store in Q and mark as visited */
                if (!vis[it]) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
    }

    /* Helper function to recursively
    perform DFS from the node */
    private void dfs(int node, List<Integer>[] adj, boolean[] vis, 
                     List<Integer> ans) {
        // Mark the node as visited
        vis[node] = true;

        // Add the node to the result
        ans.add(node);

        // Traverse all its neighbours
        for (int it : adj[node]) {
            // If the neighbour is not visited
            if (!vis[it]) {
                // Perform DFS recursively
                dfs(it, adj, vis, ans);
            }
        }
    }

    /* Function to return a list containing
    the DFS traversal of the graph */
    public List<Integer> dfsOfGraph(int V, List<Integer>[] adj) {
        // Visited array
        boolean[] vis = new boolean[V];

        // Create a list to store DFS
        List<Integer> ans = new ArrayList<>();

        // Traverse all the nodes
        for (int i = 0; i < V; i++) {
            // If the node is unvisited
            if (!vis[i]) {
                // Call DFS from that node
                dfs(i, adj, vis, ans);
            }
        }

        // Return the result
        return ans;
    }

    /* Function to return a list containing
    the BFS traversal of the graph */
    public List<Integer> bfsOfGraph(int V, List<Integer>[] adj) {
        // Visited array
        boolean[] vis = new boolean[V];

        // To store the result
        List<Integer> ans = new ArrayList<>();

        // Traverse all the nodes
        for (int i = 0; i < V; i++) {
            // If the node is unvisited
            if (!vis[i]) {
                // Mark the node as visited
                vis[i] = true;

                // Call BFS from that node
                bfs(i, adj, vis, ans);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int V = 5;
        List<Integer>[] adj = new List[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].addAll(Arrays.asList(2, 3, 1));
        adj[1].add(0);
        adj[2].addAll(Arrays.asList(0, 4));
        adj[3].add(0);
        adj[4].add(2);

        // Creating instance of dfsandbfstraverse class
        dfsandbfstraverse sol = new dfsandbfstraverse();

        // Function call to get the BFS traversal of graph
        List<Integer> bfs = sol.bfsOfGraph(V, adj);

        // Function call to get the DFS traversal of graph
        List<Integer> dfs = sol.dfsOfGraph(V, adj);

        // Output
        System.out.println("The BFS traversal of the given graph is: " + bfs);
        System.out.println("The DFS traversal of the given graph is: " + dfs);
    }
}
