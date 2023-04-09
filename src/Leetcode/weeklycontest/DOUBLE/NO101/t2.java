package Leetcode.weeklycontest.DOUBLE.NO101;

import java.util.HashMap;
import java.util.Map;

public class t2 {
  public int maximumCostSubstring(String s, String chars, int[] vals) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < chars.length(); ++i) {
      map.put(chars.charAt(i), vals[i]);
    }

    int n = s.length();
    int[] dp = new int[n + 1];
    int res = 0;
    for (int i = 1; i < n + 1; ++i) {
      int val = 0;
      if (map.containsKey(s.charAt(i - 1))) {
        val = map.get(s.charAt(i - 1));
      } else {
        val = s.charAt(i - 1) - 'a' + 1;
      }

      dp[i] = Math.max(dp[i - 1] + val, val);
      res = Math.max(res, dp[i]);
    }

    return res;
  }
}
