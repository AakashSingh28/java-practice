package com.java.algo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionBFS {



    public static String cycleDetection(int[][] edges, int n, int m) {

        ArrayList<ArrayList<Integer>> adjList = Utility.createAdjacencyListWithMatrix(edges);
        boolean vis[] = new boolean[n];
        int parent[] = new int[n];
        Arrays.fill(parent,-1);

        checkForCycle(adjList,-1,vis,parent);
        return "YES";
    }
    // This method is for undirected graph
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean vis[] = new boolean[V];
        Arrays.fill(vis,false);
        int parent[] = new int[V];
        Arrays.fill(parent,-1);

        for(int i=0;i<V;i++)
            if(vis[i]==false)
                if(checkForCycle(adj, i,vis, parent))
                    return true;

        return false;
    }
    static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s,
                                 boolean vis[], int parent[])
    {
        Queue<Node> q =  new LinkedList<>(); //BFS
        q.add(new Node(s, -1));
        vis[s] =true;

        while(!q.isEmpty())
        {
            int node = q.peek().first;
            int par = q.peek().second;
            q.remove();

            // go to all the adjacent nodes
            for(Integer it: adj.get(node))
            {
                if(vis[it]==false)
                {
                    q.add(new Node(it, node));
                    vis[it] = true;
                }
                else if(par != it) return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int[][] edges1 = {
                {1, 2},
                {2, 3}
        };
        int n = 3;
        int m = 2;
        int N = 3;
        int[][] edges2 = {{1, 2}, {2, 3}, {1, 3}};
        System.out.println(cycleDetection(edges1,n,m));
    }
}
class Node {
    int first;
    int second;
    public Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}