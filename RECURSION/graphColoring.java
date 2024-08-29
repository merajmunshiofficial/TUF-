package RECURSION;

import java.util.*;

class graphColoring {

    // Function to check if it's safe to color the node with a given color
    private boolean isSafe(int col, int node, int[] colors, List<List<Integer>> adj) {
        // Check adjacent nodes
        for (int neighbor : adj.get(node)) {
            // If an adjacent node has the same color
            if (colors[neighbor] == col) return false;
        }
        return true; // Safe to color
    }

    // Recursive function to solve graph coloring problem
    private boolean solve(int node, int m, int n, int[] colors, List<List<Integer>> adj) {
        // If all nodes are colored
        if (n == node) return true;
        // Try all colors from 1 to m
        for (int i = 1; i <= m; i++) {
            // Check if it is safe to color the node with color i
            if (isSafe(i, node, colors, adj)) {
                colors[node] = i; // Assign color i to node
                // Recursively try to color the next node
                if (solve(node + 1, m, n, colors, adj)) return true;
                colors[node] = 0; // Reset color if it doesn't lead to a graphColoring
            }
        }
        return false; // No color can be assigned
    }

    // Function to check if the graph can be colored with m colors
    public boolean graphColoring(int[][] edges, int m, int n) {
        // Create adjacency list representation of the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        // Build the graph from edges
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        int[] colors = new int[n]; // Initialize all colors to 0 (uncolored)
        // Start solving from the first node
        return solve(0, m, n, colors, adj);
    }

    public static void main(String[] args) {
        graphColoring sol = new graphColoring();
        int[][] edges = {
            {0, 1}, {0, 2}, {1, 2}, {1, 3}
        };
        int m = 3; // Number of colors
        int n = 4; // Number of nodes

        // Check if the graph can be colored with m colors
        if (sol.graphColoring(edges, m, n)) {
            System.out.println("The graph can be colored with " + m + " colors.");
        } else {
            System.out.println("The graph cannot be colored with " + m + " colors.");
        }
    }
}
