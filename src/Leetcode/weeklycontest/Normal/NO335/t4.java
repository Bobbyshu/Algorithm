package Leetcode.weeklycontest.Normal.NO335;

public class t4 {
  public int waysToReachTarget(int target, int[][] types) {
    int MOD = (int) 1e9 + 7;
    int n = types.length;
    int[][] dp = new int[n + 1][target + 1];

    dp[0][0] = 1;

    for (int i = 1; i <= n; i++) {
      int cnt = types[i - 1][0];
      int m = types[i - 1][1];
      for (int j = 0; j <= target; j++) {
        dp[i][j] = dp[i - 1][j];
        for (int k = 1; k <= cnt; k++) {
          if (j >= k * m) {
            dp[i][j] = (dp[i][j] + dp[i - 1][j - k * m]) % MOD;
          } else {
            break;
          }
        }
      }
    }

    return dp[n][target];
  }
}
