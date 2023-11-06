package com.java.algo.graph;

import java.util.Arrays;

/*An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel
of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color),
and so on. Replace the color of all of the aforementioned pixels with color.*/
public class FloodFill {


    // TC :: O(M*N)*4 ~ O(M*N)

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int initialColor = image[sr][sc];
        int[][] result = image;

        dfs(result,image,sr,sc,color,initialColor);

     return result;
    }

    private static void dfs(int[][] result, int[][] image, int sr, int sc, int color, int initialColor) {
        result[sr][sc] = color;
        int n = image.length;
        int m = image[0].length;

        int[] delRow = {-1,0,+1,0};
        int[] delCol = {0,+1,0,-1};

        for (int i = 0; i < 4; i++) {
            int nRow = sr+delRow[i];
            int nCol = sc+delCol[i];

            if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && image[nRow][nCol]==initialColor && result[nRow][nCol]!=color){
                dfs(result,image,nRow,nCol,color,initialColor);
            }

        }

    }


    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1;
        int sc = 1;
        int color = 2;
        int[][] result = floodFill(image,sr,sc,color);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j <result[0].length; j++) {
                System.out.print(" "+result[i][j]);
            }
            System.out.println();
        }
    }
}
