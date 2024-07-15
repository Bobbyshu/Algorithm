package Leetcode.weeklycontest.Normal.NO406;

import java.util.Arrays;

public class t3and4 {
  public long minimumCost(int m, int n, int[] hor, int[] ver) {
    int h = hor.length, v = ver.length;
    Arrays.sort(hor);
    Arrays.sort(ver);

    long x = 1, y = 1;
    int idx1 = h - 1, idx2 = v - 1;

    long res = 0;
    while (idx1 >= 0 && idx2 >= 0) {
      // cut horizon
      if (hor[idx1] >= ver[idx2]) {
        res += y * hor[idx1];
        idx1--;
        x++;
      } else {
        res += x * ver[idx2];
        idx2--;
        y++;
      }
    }
    // System.out.println(res);

    while (idx1 >= 0) {
      res += y * hor[idx1--];
    }

    while (idx2 >= 0) {
      res += x * ver[idx2--];
    }

    return res;
  }
}
