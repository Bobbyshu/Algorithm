package A_OnsiteClassical.grind75;

import java.util.Arrays;

public class coinExchange {
  public int coinChange(int[] coins, int amount) {
    int n = coins.length;
    int[][] dp = new int[n + 1][amount + 1];

    for (int[] d : dp) {
      Arrays.fill(d, Integer.MAX_VALUE / 2);
    }

    dp[0][0] = 0;

    for (int i = 1; i <= n; ++i) {
      for (int j = 0; j <= amount; ++j) {
        dp[i][j] = dp[i - 1][j];
        if (j >= coins[i - 1]) {
          dp[i][j] = Math.min(dp[i][j], dp[i][j - coins[i - 1]] + 1);
        }
      }
    }

    return dp[n][amount] == Integer.MAX_VALUE / 2 ? -1 : dp[n][amount];
  }
}
