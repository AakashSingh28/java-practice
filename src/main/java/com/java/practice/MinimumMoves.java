package com.java.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Arrays;
import java.util.List;

public class MinimumMoves {

    public static int getMinimumMoves(List<List<Integer>> maze, int k) {
        int n = maze.size();
        int m = maze.get(0).size();

        int[][] dp = new int[n][m];

        // Initialize the dp array with a large value to represent infinity
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // HackerMan is initially at (0, 0)
        dp[0][0] = 0;

        // Dynamic Programming to fill the dp array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze.get(i).get(j) == 0) {
                    // Try all possible moves within the jump parameter k
                    for (int x = 1; x <= k; x++) {
                        // Move right
                        if (j + x < m && maze.get(i).get(j + x) == 0) {
                            dp[i][j + x] = Math.min(dp[i][j + x], dp[i][j] + 1);
                        }

                        // Move down
                        if (i + x < n && maze.get(i + x).get(j) == 0) {
                            dp[i + x][j] = Math.min(dp[i + x][j], dp[i][j] + 1);
                        }
                    }
                }
            }
        }
         if(dp[n - 1][m - 1]<0){
             return  -1;
         }
        // Return the result for the destination cell
        return dp[n - 1][m - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        // Example usage
        List<List<Integer>> result = Arrays.asList(
                Arrays.asList(0, 1, 0),
                Arrays.asList(1, 0, 0)
        );
        int k = 5;
        System.out.println(getMinimumMoves(result,k)); // Output: 2
    }
}