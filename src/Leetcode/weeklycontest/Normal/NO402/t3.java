package Leetcode.weeklycontest.Normal.NO402;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class t3 {
  public long maximumTotalDamage(int[] power) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int p : power) {
      map.merge(p, 1, Integer::sum);
    }

    int[] arr = new int[map.size()];
    int k = 0;
    for (int key : map.keySet()) {
      arr[k++] = key;
    }

    Arrays.sort(arr);
    int n = map.size();

    // dp[i] states that the largest damage we can get
    // when we cast the ith spells
    // dp[i] = max(a_j < a_i - 2) (dp[j] + cur spell * occurrence of this spell)

    long[] dp = new long[n];
    long max = 0;
    for (int i = 0, j = 0; i < n; ++i) {
      while (j < i && arr[j] < arr[i] - 2) {
        max = Math.max(max, dp[j]);
        ++j;
      }
      dp[i] = max + (long) arr[i] * (long) map.get(arr[i]);
    }

    long res = 0L;
    for (int i = 0; i < n; ++i) {
      res = Math.max(res, dp[i]);
    }

    return res;
  }
}
