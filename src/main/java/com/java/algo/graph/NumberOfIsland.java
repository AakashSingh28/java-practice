package com.java.algo.graph;

import java.util.LinkedList;
import java.util.Queue;

 class Pair{
    int first;
    int second;
     public Pair(int first, int second) {
         this.first = first;
         this.second = second;
     }
 }
public class NumberOfIsland {


     // TC O(N2)
    public static int numIslands(char[][] grid) {
       int count =0;
       int row = grid.length;
       int col = grid[0].length;

       int[][] visited = new int[row][col];

      for (int i=0; i<row; i++){
          for (int j=0; j<col; j++){
              if(grid[i][j] == '1' && visited[i][j]==0){
                   count++;
                   bfs(i,j,visited,grid);
                //   dfs(i,j,visited,grid);
              }
          }
      }

       return count;
    }

    // Giving wrong result
    private static void dfs(int ro, int co, int[][] visited, char[][] grid) {
        visited[ro][co] = 1;
        int n = grid.length;
        int m = grid[0].length;

        for(int delRow = -1; delRow<=1;delRow++) {
            for(int delCol = -1; delCol <= 1; delCol++) {
                int   nRow = ro+delRow;
                int   nCol = co+delCol;
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                        && grid[nRow][nCol] == '1' && visited[nRow][nCol] == 0) {
                    visited[nRow][nCol] = 1;

                    dfs(nRow, nCol, visited, grid);
                }
            }
        }
    }
    private static void bfs(int ro, int co, int[][] visited, char[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(ro,co));
         int n = grid.length;
         int m = grid[0].length;
        while (!queue.isEmpty()){
            int row = queue.peek().first;
            int col = queue.peek().second;
            queue.remove();

            for(int delRow = -1; delRow<=1;delRow++) {
                for(int delCol = -1; delCol <= 1; delCol++) {
                 int   nRow = row+delRow;
                 int   nCol = col+delCol;
                    if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                            && grid[nRow][nCol] == '1' && visited[nRow][nCol] == 0) {
                    visited[nRow][nCol] = 1;
                    queue.add(new Pair(nRow,nCol));

                }
            }
            }

        }
    }


    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println(numIslands(grid));
    }
}
