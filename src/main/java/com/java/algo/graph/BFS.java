package com.java.algo.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    // Undirected Graph
    //  TC : O(N) + O(2*E) [Submission of Degree]
    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj){
        List<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        visited[0]=true;
        queue.offer(0);

        while(!queue.isEmpty()){

            int node = queue.poll();
            bfs.add(node);

            for(Integer it : adj.get(node)){
                if(visited[it] == false){
                    visited[it] = true;
                    queue.offer(it);
                }
            }

        }

        return bfs;
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

        List<Integer> bfsResult = bfsTraversal(n, adj);
        System.out.println("BFS traversal result: " + bfsResult);
    }
}
