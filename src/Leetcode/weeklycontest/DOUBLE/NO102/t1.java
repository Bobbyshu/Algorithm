package Leetcode.weeklycontest.DOUBLE.NO102;

public class t1 {
  public int[] findColumnWidth(int[][] grid) {
    int n = grid[0].length;
    int[] res = new int[n];

    for (int j = 0; j < n; ++j) {
      int max = 0;
      for (int i = 0; i < grid.length; ++i) {
        max = Math.max(max, String.valueOf(grid[i][j]).length());
      }
      res[j] = max;
    }

    return res;
  }
}
