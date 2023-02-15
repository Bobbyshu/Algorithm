package Trick.prefix.TwoDPrefix;

public class Prefix2D {
  private int[][] preSum;

  public Prefix2D(int[][] matrix, int threshold) {
    int m = matrix.length, n = matrix[0].length;
    // 构造前缀和矩阵
    preSum = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        // 计算每个矩阵 [0, 0, i, j] 的元素和
        preSum[i][j] = preSum[i - 1][j]
            + preSum[i][j - 1]
            - preSum[i - 1][j - 1]
            + matrix[i - 1][j - 1];
      }
    }

    int l = 0, r = Math.min(m, n);
    while (l < r) {
      int mid = (l + r + 1) >> 1;
      boolean flag = false;

      for (int i = 1; i <= m - mid + 1; ++i) {
        for (int j = 1; j <= n - mid + 1; ++j) {
          int temp = preSum[i + mid - 1][j + mid - 1]
              
              - preSum[i + mid - 1][j - 1]
              - preSum[i - 1][j + mid - 1]
              + preSum[i - 1][j - 1];
          if (temp <= threshold) {
            flag = true;
          }
        }
      }

      if (flag) {
        l = mid;
      } else {
        r = mid - 1;
      }
    }
  }

  // 计算子矩阵 [x1, y1, x2, y2] 的元素和
  public int sumRegion(int x1, int y1, int x2, int y2) {
    // 目标矩阵之和由四个相邻矩阵运算获得
    return preSum[x2 + 1][y2 + 1]
        - preSum[x1][y2 + 1]
        - preSum[x2 + 1][y1]
        + preSum[x1][y1];
  }
}
