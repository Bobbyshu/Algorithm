package Leetcode.weeklycontest.DOUBLE.NO118;

import java.util.Arrays;

public class T3 {public int minimumCoins(int[] prices) {
  int n = prices.length;
  // dp[n][0] states free, dp[0][1] states cost
  int[][] dp = new int[n][2];

  for (int[] d : dp) {
    Arrays.fill(d, 999999);
  }

  dp[0][0] = prices[0];
  dp[0][1] = prices[0];

  for (int i = 1; i < n; ++i) {
    // at most money spend(avoid zero)
    // dp[i][0] = dp[i - 1][0] + prices[i];
    for (int j = i / 2; j < i; ++j) {
      // free one can only source from cost one
      dp[i][0] = Math.min(dp[i][0], dp[j][1]);
      // cost
      dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + prices[i];
    }
  }
  // System.out.println(Arrays.deepToString(dp));

  return Math.min(dp[n - 1][0], dp[n - 1][1]);
}


  // 1 10 1 1
  // 1
  // 1
}
