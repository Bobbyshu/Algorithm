package Leetcode.weeklycontest.Normal.NO405;

public class t3 {
  // 0 0 0 0
  // 0 1 0 0
  // 0 0 -1 -1
  public int numberOfSubmatrices(char[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[][] mat = new int[m][n];

    int[][] preSumX = generatePresum(grid, 'X');
    int[][] preSumY = generatePresum(grid, 'Y');

    int res = 0;
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (preSumX[i][j] == preSumY[i][j] && preSumX[i][j] > 0) {
          ++res;
        }
      }
    }

    // System.out.println(Arrays.deepToString(preSum));
    return res;
  }

  private int[][] generatePresum(char[][] arr, char c) {
    int m = arr.length, n = arr[0].length;
    int[][] res = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        res[i][j] = res[i - 1][j]
            + res[i][j - 1]
            - res[i - 1][j - 1];
        if (arr[i - 1][j - 1] == c) {
          res[i][j]++;
        }
      }
    }
    return res;
  }
}
