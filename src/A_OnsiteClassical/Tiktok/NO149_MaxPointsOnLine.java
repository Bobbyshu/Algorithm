package A_OnsiteClassical.Tiktok;

import java.util.HashMap;
import java.util.Map;

public class NO149_MaxPointsOnLine {
  // 究极暴力n^3
  public int maxPoints(int[][] points) {
    int n = points.length, res = 1;
    for (int i = 0; i < n; i++) {
      int[] x = points[i];
      for (int j = i + 1; j < n; j++) {
        int[] y = points[j];
        // 枚举点对 (i,j) 并统计有多少点在该线上, 起始 cnt = 2 代表只有 i 和 j 两个点在此线上
        int cnt = 2;
        for (int k = j + 1; k < n; k++) {
          int[] p = points[k];
          int s1 = (y[1] - x[1]) * (p[0] - y[0]);
          int s2 = (p[1] - y[1]) * (y[0] - x[0]);
          if (s1 == s2) cnt++;
        }
        res = Math.max(res, cnt);
      }
    }
    return res;
  }

  public int Optimize(int[][] points) {
    int n = points.length, res = 1;
    for (int i = 0; i < n; i++) {
      Map<String, Integer> map = new HashMap<>();
      // 由当前点 i 发出的直线所经过的最多点数量
      int max = 0;
      for (int j = i + 1; j < n; j++) {
        int x1 = points[i][0], y1 = points[i][1], x2 = points[j][0], y2 = points[j][1];
        int a = x1 - x2, b = y1 - y2;
        int k = gcd(a, b);
        String key = (a / k) + "_" + (b / k);
        map.put(key, map.getOrDefault(key, 0) + 1);
        max = Math.max(max, map.get(key));
      }
      res = Math.max(res, max + 1);
    }
    return res;
  }
  int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }
}
