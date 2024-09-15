package A_OnsiteClassical.Tiktok;

import java.util.Arrays;

public class LongestIncreasingPath329 {
  public int longestIncreasingPath(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    int[][] memo = new int[m][n];
    for (int[] row : memo) {
      Arrays.fill(row, -1);
    }

    int res = 1;
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if (memo[i][j] == -1) {
          res = Math.max(res, dfs(matrix, i, j, memo));
        }
      }
    }

    return res;
  }

  private int dfs(int[][] matrix, int i, int j, int[][] memo) {
    if (memo[i][j] != -1) {
      return memo[i][j];
    }

    int res = 1;
    int[][] directions = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    for (int[] direction : directions) {
      int nextI = i + direction[0];
      int nextJ = j + direction[1];
      if (nextI >= 0 && nextJ >= 0 && nextI < matrix.length
          && nextJ < matrix[0].length && matrix[nextI][nextJ] > matrix[i][j]) {
        res = Math.max(res, dfs(matrix, nextI, nextJ, memo) + 1);
      }
    }

    memo[i][j] = res;
    return res;
  }
}
