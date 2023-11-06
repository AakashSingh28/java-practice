package com.java.algo.graph;

import java.util.ArrayList;

public class Utility {

    public static ArrayList<ArrayList<Integer>> createAdjacencyListWithMatrix(int[][] matrix) {
        int n = matrix.length; // Number of vertices

        // Initialize an empty adjacency list with n vertices.
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Populate the adjacency list based on the matrix.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    adjList.get(i).add(j); // Add the neighboring vertex to the adjacency list.
                }
            }
        }

        return adjList;
    }
}
