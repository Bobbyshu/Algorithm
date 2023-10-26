package Leetcode.weeklycontest.DOUBLE.NO115;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class t2 {
  public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] g) {
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    // dp[0][0] = groups[0] == 0 ? 1 : 0;
    // dp[0][1] = groups[0] == 0 ? 0 : 1;
    int[] path = new int[n];
    // path[0] = -1;
    Arrays.fill(path, -1);

    int max = 0, maxIdx = 0;
    for (int i = 1; i < n; ++i) {
      for (int j = i - 1; j >= 0; --j) {
        if (g[i] != g[j]) {
          if (dp[j] + 1 > dp[i]) {
            dp[i] = dp[j] + 1;
            path[i] = j;
          }
        }
      }
      if (dp[i] > max) {
        max = Math.max(max, dp[i]);
        maxIdx = i;
      }
    }
    // System.out.println(Arrays.toString(dp));
    // System.out.println(maxIdx);
    // System.out.println(Arrays.toString(path));

    List<String> res = new ArrayList<>();
    for (int j = maxIdx; j >= 0; j = path[j]) {
      res.add(words[j]);
    }

    Collections.reverse(res);
    return res;
  }
}
