package A_OnsiteClassical.Tiktok;

import java.util.*;

public class WordBreakII140 {
  public List<String> wordBreak(String s, List<String> wordDict) {
    Set<String> set = new HashSet(wordDict);
    int n = s.length();

    boolean[] dp = new boolean[n + 1];
    dp[0] = true;

    for (int r = 1; r <= n; ++r) {
      for (int l = r - 1; l >= 0; --l) {
        if (set.contains(s.substring(l, r)) && dp[l]) {
          dp[r] = true;
          break;
        }
      }
    }

    List<String> res = new ArrayList<>();
    if (dp[n]) {
      Deque<String> path = new ArrayDeque<>();
      dfs(s, n, set, dp, path, res);
      return res;
    }

    return res;
  }

  private void dfs(String s, int n, Set<String> set, boolean[] dp, Deque<String> path, List<String> res) {
    if (n == 0) {
      res.add(String.join(" ", path));
      return;
    }

    // n * 2^n
    for (int i = n - 1; i >= 0; --i) {
      String suffix = s.substring(i, n);
//      System.out.println(suffix);
      if (set.contains(suffix) && dp[i]) {
        path.addFirst(suffix);
        dfs(s, i, set, dp, path, res);
        path.removeFirst();
      }
    }
  }
}
