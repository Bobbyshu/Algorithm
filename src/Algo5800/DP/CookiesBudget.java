package Algo5800.DP;

import java.util.Arrays;

public class CookiesBudget {
  public static void main(String[] args) {
    int[] arr = {1, 2, 5};
    coinChange(arr, 11);
  }

  public static int coinChange(int[] cookies, int Budget) {
    int min = Integer.MIN_VALUE;
    // dp[j]含义为凑足总额为j所需钱币的最多个数为dp[j]
    int[] dp = new int[Budget + 1];
    Arrays.fill(dp, min);

    // 当金额为0时需要的硬币数目也为0
    // dp[j]只能由dp[j - cookies[i]]递推而来，dp[j] = dp[j - cookies[i]] + 1
    // dp[j]要取所有可以递推来的数目中最少的那个即可
    dp[0] = 0;
    for (int i = 0; i < cookies.length; i++) {
      for (int j = cookies[i]; j <= Budget; j++) {
        if (dp[j - cookies[i]] != min) {
          dp[j] = Math.max(dp[j], dp[j - cookies[i]] + 1);
        }
      }
    }

    return dp[Budget] == min ? -1 : dp[Budget];
  }
}
