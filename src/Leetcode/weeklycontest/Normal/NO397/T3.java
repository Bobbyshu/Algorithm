package Leetcode.weeklycontest.Normal.NO397;

import java.util.Arrays;
import java.util.List;

public class T3 {
  // dp[i][j] states that the minimum value in square whose
  // right bottom point is (i,j)
  public int maxScore(List<List<Integer>> grid) {
    int m = grid.size();
    int n = grid.get(0).size();
    int res = Integer.MIN_VALUE / 2;
    int[][] dp = new int[m][n];

    // Initialize the array with Integer.MAX_VALUE / 2
    for (int[] d : dp) {
      Arrays.fill(d, Integer.MAX_VALUE / 2);
    }

    // Populate the first column of the array
    for (int i = 1; i < m; i++) {
      dp[i][0] = Math.min(dp[i - 1][0], grid.get(i - 1).get(0));
      res = Math.max(res, grid.get(i).get(0) - dp[i][0]);
    }

    // Populate the first row of the array
    for (int j = 1; j < n; j++) {
      dp[0][j] = Math.min(dp[0][j - 1], grid.get(0).get(j - 1));
      res = Math.max(res, grid.get(0).get(j) - dp[0][j]);
    }

    // Populate the rest of the array
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = Math.min(
            Math.min(dp[i - 1][j], dp[i][j - 1]),
            Math.min(grid.get(i).get(j - 1), grid.get(i - 1).get(j))
        );
        res = Math.max(res, grid.get(i).get(j) - dp[i][j]);
      }
    }

    return res;
  }

}
