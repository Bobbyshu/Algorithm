package Leetcode.weeklycontest.DOUBLE.NO141;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T3 {
  int[][] memo;
  int[] targetIndices;
  Set<Integer> set;

  public int maxRemovals(String source, String pattern, int[] targetIndices) {
    int n = source.length(), m = pattern.length();
    this.targetIndices = targetIndices;
    this.set = new HashSet<>();
    for (int i : targetIndices) {
      set.add(i);
    }

    memo = new int[n][m + 1];
    for (int[] me : memo) {
      Arrays.fill(me, -1);
    }

    return dfs(source, n - 1, pattern, m - 1);
  }

  private int dfs(String s, int i, String p, int j) {
    if (i < j) {
      return Integer.MIN_VALUE;
    }

    if (i < 0) {
      return 0;
    }

    if (memo[i][j + 1] != -1) {
      return memo[i][j + 1];
    }

    // 跳过当前字符的结果（不移除）
    int res = dfs(s, i - 1, p, j);
    // 移除的选项
    if (set.contains(i)) {
      ++res;
    }

    // 匹配的选项
    if (j >= 0 && s.charAt(i) == p.charAt(j)) {
      res = Math.max(res, dfs(s, i - 1, p, j - 1));
    }


    memo[i][j + 1] = res;
    return res;
  }
}
