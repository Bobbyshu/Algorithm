package Leetcode.weeklycontest.Normal.NO340;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class t4 {
  public int minimumVisitedCells(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      Arrays.fill(dp[i], -1);
    }
    dp[0][0] = 1;
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{0, 0});
    while (!q.isEmpty()) {
      int[] curr = q.poll();
      int i = curr[0], j = curr[1];
      for (int k = j + 1; k <= j + grid[i][j] && k < n; k++) {
        if (dp[i][k] == -1) {
          dp[i][k] = dp[i][j] + 1;
          q.offer(new int[]{i, k});
        }
      }
      for (int k = i + 1; k <= i + grid[i][j] && k < m; k++) {
        if (dp[k][j] == -1) {
          dp[k][j] = dp[i][j] + 1;
          q.offer(new int[]{k, j});
        }
      }
    }
    return dp[m - 1][n - 1];
  }
}
