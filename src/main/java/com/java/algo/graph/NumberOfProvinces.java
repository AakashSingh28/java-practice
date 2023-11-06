package com.java.algo.graph;

import java.util.ArrayList;
import java.util.List;

/*There are n cities. Some of them are connected, while some are not.
  If city a is connected directly with city b, and city b is connected directly with city c,
  then city a is connected indirectly with city c.
A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1
if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.
*/


public class NumberOfProvinces {


    // TC :: O(N) + O(V + 2E)  ~ O(V+2E)

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                }
            }
        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, visited, adjList);
            }
        }

        return count;
    }

    private static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;

        for (int it : adj.get(node)) {
            if (!visited[it]) {
                dfs(it, visited, adj);
            }
        }
    }


    public static void main(String[] args) {
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(findCircleNum(isConnected));
    }
}
