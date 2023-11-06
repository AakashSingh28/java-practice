package com.java.algo.graph;


import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cuntFresh = 0;

        int[][] visited = new int[n][m];

        Queue<PairWithTime> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]==2){
                queue.offer(new PairWithTime(i,j,0));
                    visited[i][j] = 2;
                }else {
                    visited[i][j] = 0;
                }
                if(grid[i][j]==1) cuntFresh++;
            }
        }
        int tm = 0;
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        int count = 0;
        while (!queue.isEmpty()){

            int row = queue.peek().first;
            int col = queue.peek().second;
            int time = queue.peek().time;
            tm = Math.max(tm,time);
            queue.poll();

            for (int i = 0; i < 4; i++) {
             int rRow = row + delRow[i];
             int rCol = col + delCol[i];

             if(rRow>=0 && rRow<n && rCol>=0 && rCol<m && visited[rRow][rCol]!=2 && grid[rRow][rCol]==1){
                   queue.offer(new PairWithTime(rRow,rCol,time+1));
                   visited[rRow][rCol] = 2;
                   count++;
             }

            }

        }

        if(count!=cuntFresh) return -1;

        return tm;
    }


    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        System.out.println(orangesRotting(grid));
    }
}
class PairWithTime{
    int first;
    int second;
    int time;
    public PairWithTime(int first, int second, int time) {
        this.first = first;
        this.second = second;
        this.time = time;
    }
}