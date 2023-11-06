package com.java.algo.graph;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    // Undirected Graph
    //  TC : O(N) + O(2*E) [Submission of Degree]
    private static List<Integer> dfsTraversal(int n, List<List<Integer>> adj) {
        List<Integer> dfs = new ArrayList<>();
        boolean[] visited = new boolean[n];
        visited[0] = true;

        dfs(0,visited,adj,dfs);

        return dfs;
    }

    private static void dfs(int node, boolean[] visited, List<List<Integer>> adj, List<Integer> dfs) {
        visited[node] = true;
        dfs.add(node);

        for (int it : adj.get(node)){
            if(visited[it] == false){
                dfs(it,visited,adj,dfs);
            }
        }

    }


    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> adj = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(1).add(4);
        adj.get(2).add(5);

        List<Integer> result = dfsTraversal(n, adj);
        System.out.println("BFS traversal result: " + result);
    }
}
