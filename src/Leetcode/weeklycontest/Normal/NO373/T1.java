package Leetcode.weeklycontest.Normal.NO373;

public class T1 {
  // 0 1 2 3
  // 3 -> 1
  // 2 -> 0
  // 1 -> 3
  // 0 -> 2
  public boolean areSimilar(int[][] mat, int k) {
    int n = mat.length, m = mat[0].length;
    k %= m;
    int[][] arr = new int[n][m];

    for (int i = 0; i < n; ++i) {
      if (i % 2 == 0) {
        for (int j = 0; j < m; ++j) {
          arr[i][(j + m - k) % m] = mat[i][j];
        }
      } else {
        for (int j = 0; j < m; ++j) {
          arr[i][(j + k) % m] = mat[i][j];
        }
      }
    }

    // System.out.println(Arrays.deepToString(arr));

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        if (mat[i][j] != arr[i][j]) {
          return false;
        }
      }
    }

    return true;
  }
}
