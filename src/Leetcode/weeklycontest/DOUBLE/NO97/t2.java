package Leetcode.weeklycontest.DOUBLE.NO97;

import java.util.HashSet;
import java.util.Set;

public class t2 {
  public int maxCount(int[] banned, int n, int maxSum) {
    Set<Integer> set = new HashSet<>();
    for (int b : banned) {
      set.add(b);
    }

    long sum = 0L;
    int cnt = 0;
    for (int i = 1; i <= n; ++i) {
      if (sum > maxSum) {
        return cnt - 1;
      }
      if (!set.contains(i)) {
        sum += i;
        ++cnt;
      }
    }

    return sum > maxSum ? cnt - 1 : cnt;
  }
}
