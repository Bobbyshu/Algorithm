package A_OnsiteClassical.grind75;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordBreak139 {
  public static void main(String[] args) {
    List<String> w = new ArrayList<>();
    w.add("apple");
    w.add("pen");
    wordBreak("applepenapple", w);
  }
  public static boolean wordBreak(String s, List<String> wordDict) {
    int n = s.length();
    // dp[i] states that the previous ith for s can be used in wordDict
    boolean[] dp = new boolean[n + 1];
    // base case
    dp[0] = true;
    Set<String> set = new HashSet<>(wordDict);

    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        // dp[j] for previous substring(0, j) check
        // contains for suffix check substring(j, i)
        // only both two segment valid we can set dp[i] = true
        if (set.contains(s.substring(j, i)) && dp[j]) {
          dp[i] = true;
          break;
        }
      }
    }

    return dp[n];
  }
}
