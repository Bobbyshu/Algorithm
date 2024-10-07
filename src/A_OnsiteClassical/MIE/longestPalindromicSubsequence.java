package A_OnsiteClassical.MIE;

public class longestPalindromicSubsequence {
  public int longestPalindromeSubseq(String s) {
    int n = s.length();
    if (n == 1) {
      return 1;
    }
    // dp[i][j] states that the longest subsequence in substring[i,j]
    int[][] dp = new int[n][n];

    for (int i = 0; i < n; i++) {
      dp[i][i] = 1;
    }

    // left_boundary start from tail so we won't count overlap
    for (int i = n - 1; i >= 0; i--) {
      for (int j = i + 1; j < n; j++) {
        if (s.charAt(i) == s.charAt(j)) {
          dp[i][j] = 2 + dp[i + 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[0][n - 1];
  }
}
