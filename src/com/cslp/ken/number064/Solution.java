package com.cslp.ken.number064;

public class Solution {
  public int minPathSum(int[][] grid) {
    if(grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int rows = grid.length;
    int cols = grid[0].length;
    int[][] dp = new int[rows][cols];
    dp[0][0] = grid[0][0];
    for (int i = 1; i < rows; i++) {
      dp[i][0] = dp[i - 1][0] + grid[i][0];
    }

    for (int i = 0; i < cols; i++) {
      dp[0][i] = dp[0][i - 1] + grid[0][i];
    }

    for (int i = 1; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
      }
    }

    return dp[rows - 1][cols - 1];
  }
}

