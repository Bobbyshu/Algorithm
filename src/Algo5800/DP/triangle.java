package Algo5800.DP;

import java.util.List;

public class triangle {
  public String minimumTotal(List<List<Integer>> triangle, int target) {
    int n = triangle.size();
    int[][] dp = new int[n][n];

    // 初始化最后一行
    for (int i = 0; i < n; i++) {
      dp[n - 1][i] = triangle.get(n - 1).get(i);
    }

    for (int i = n - 2; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
      }
    }

    int row = 0, col = 0;
    StringBuilder path = new StringBuilder();

    while (row < n - 1) {
      if (col < n - 1 && dp[row][col] + triangle.get(row + 1).get(col) == dp[row + 1][col]) {
        path.append("L");
      } else {
        path.append("R");
        col++;
      }
      row++;
    }

    if (dp[0][0] == target) {
      return path.toString();
    } else {
      return "No path found to reach the target.";
    }
  }

}
