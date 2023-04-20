package Leetcode.weeklycontest.Normal.NO341;

public class t1 {
  public int[] rowAndMaximumOnes(int[][] mat) {
    int m = mat.length, n = mat[0].length;
    int max = 0, maxIdx = 0;
    for (int i = 0; i < m; ++i) {
      int cnt = 0;
      for (int j = 0; j < n; ++j) {
        if (mat[i][j] == 1) {
          ++cnt;
        }
      }
      if (cnt > max) {
        max = cnt;
        maxIdx = i;
      }
    }

    return new int[]{maxIdx, max};
  }
}
