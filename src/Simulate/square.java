package Simulate;

import java.util.Arrays;

public class square {
  public static void main(String[] args) {
    int[][] grid = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
    largest1BorderedSquare(grid);
  }

  public static int largest1BorderedSquare(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    // dp[i][j][0] means that the left side consecutive number(including himself)
    // dp[i][j][1] means that the upper side consecutive number(including himself)
    int[][][] dp = new int[m + 1][n + 1][2];
    for (int i = 1; i <= m; ++i) {
      for (int j = 1; j <= n; ++j) {
        if (grid[i - 1][j - 1] == 1) {
          dp[i][j][0] = dp[i][j - 1][0] + 1;
          dp[i][j][1] = dp[i - 1][j][1] + 1;
        }
      }
    }
    System.out.println(Arrays.deepToString(dp));

    // to search for available square
    // we need to search each point for his Math.min(dp[i][j][0], dp[i][j][1])
    // after getting the min side, we can check whether the
    // left side point has min side length upper
    // and upper side point has min side length left
    // if both of them have we can register the length
    int res = 0;
    for (int i = 1; i <= m; ++i) {
      for (int j = 1; j <= n; ++j) {
        int side = Math.min(dp[i][j][0], dp[i][j][1]);
        for (; side >= 1; side--) {
          if (dp[i][j - side + 1][1] >= side
          && dp[i - side + 1][j][0] >= side) {
            res = Math.max(res, side);
          }
        }
      }
    }
    return res * res;
  }
}
