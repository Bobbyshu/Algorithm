package Leetcode.weeklycontest.Normal.NO414;

import java.util.Arrays;

public class t2 {
  public int maxPossibleScore(int[] start, int d) {
    Arrays.sort(start);
    if (start.length == 2) {
      return start[1] - start[0] + d;
    }
    
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for (int s : start) {
      min = Math.min(s, min);
      max = Math.max(s, max);
    }

    long l = 0, r = (long) max - min + d;
    // System.out.println(r);
    // System.out.println(check(start,d,4));

    while (l < r) {
      long mid = (l + r + 1) / 2;

      if (check(start, d, mid)) {
        l = mid;
      } else {
        r = mid - 1;
      }
    }

    return (int) l;
  }

  private boolean check(int[] s, int d, long mid) {
    long cur = s[0];
    for (int i = 1; i < s.length; ++i) {
      if (s[i] + d < cur + mid) {
        return false;
      }

      cur = Math.max(cur + mid, s[i]);
    }

    return true;
  }
}
