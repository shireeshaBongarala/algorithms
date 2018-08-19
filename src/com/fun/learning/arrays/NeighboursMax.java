package com.fun.learning.arrays;

public class NeighboursMax {
  public static void main(String[] args) {
    int[][] matrix = {
        {5, 5, 5, 5},
        {5, 3, 5, 3},
        {4, 3, 3, 3}
    };

    int visited[][] = new int[matrix.length][matrix[0].length];

    System.out.println(getMaxNeighbours(matrix, visited));
  }

  private static int getMaxNeighbours(int[][] matrix, int[][] visited) {
    int maxCount = 0;

    for (int i = 0; i < visited.length; i++) {
      for (int j = 0; j < visited[0].length; j++) {
        if (visited[i][j] != 0) {
          continue;
        }
        int curntCoutn = dfs(i, j, visited, matrix, matrix[i][j]);
        maxCount = Math.max(maxCount, curntCoutn);
      }
    }

    return maxCount;
  }

  private static int dfs(int i, int j, int[][] visited, int[][] matrix, int val) {
    if (i >= matrix.length || i < 0) {
      return 0;
    }
    if (j >= matrix[0].length || j < 0) {
      return 0;
    }
    if (matrix[i][j] != val) {
      return 0;
    }

    if(visited[i][j]!=0) return 0;

    visited[i][j] = 1;
    return 1 +
        dfs(i, j + 1, visited, matrix, val)
        + dfs(i + 1, j, visited, matrix, val)
        + dfs(i-1, j, visited, matrix, val)
        + dfs (i, j-1, visited, matrix, val);
  }
}
