package Leetcode.weeklycontest.DOUBLE.NO115;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class t3 {
  public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
    int[] dp = new int[n];
    Arrays.fill(dp, 1);

    int[] path = new int[n];
    Arrays.fill(path, -1);

    for (int i = 1; i < n; ++i) {
      for (int j = i - 1; j >= 0; --j) {
        if (check(words[i], words[j]) && groups[i] != groups[j]) {
          if (dp[j] + 1 > dp[i]) {
            dp[i] = dp[j] + 1;
            path[i] = j;
          }
        }
      }
    }
    // System.out.println(Arrays.toString(dp));
    int max = dp[0], maxIdx = 0;
    for (int i = 1; i < n; ++i) {
      if (dp[i] > max) {
        max = dp[i];
        maxIdx = i;
      }
    }
    List<String> res = new ArrayList<>();

    for (int i = maxIdx; i >= 0; i = path[i]) {
      res.add(words[i]);
    }

    Collections.reverse(res);

    return res;
  }

  boolean check(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }

    int cnt = 0;
    for (int i = 0; i < s1.length(); ++i) {
      if (s1.charAt(i) != s2.charAt(i)) {
        ++cnt;
      }
      if (cnt > 1) {
        return false;
      }
    }

    return cnt == 1;
  }
}
