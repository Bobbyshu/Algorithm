package Leetcode.weeklycontest.DOUBLE.NO118;

import java.util.Arrays;

public class T2 {
  public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
    int len = Math.min(check(hBars), check(vBars));
    // System.out.println(check(hBars));
    // System.out.println(check(vBars));
    ++len;
    return len * len;
  }

  private int check(int[] arr) {
    Arrays.sort(arr);
    int res = 1, n = arr.length;
    // int pre = arr[0];

    for (int i = 0; i < n; ++i) {
      int cnt = 1, pre = arr[i];;
      for (int j = i + 1; j < n; ++j) {
        if (arr[j] == pre + 1) {
          ++cnt;
          pre = arr[j];
        } else {
          // res = Math.max(res, cnt);
          break;
        }

        res = Math.max(res, cnt);
      }
    }

    return res;
  }
}
