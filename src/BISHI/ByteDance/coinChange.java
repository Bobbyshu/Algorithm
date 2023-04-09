package BISHI.ByteDance;

import java.util.Arrays;

public class coinChange {
    public int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        // dp[j]含义为凑足总额为j所需钱币的最少个数为dp[j]
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);

        // 当金额为0时需要的硬币数目也为0
        // dp[j]只能由dp[j - coins[i]]递推而来，dp[j] = dp[j - coins[i]] + 1
        // dp[j]要取所有可以递推来的数目中最少的那个即可
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != max) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }

        return dp[amount] == max ? -1 : dp[amount];
    }
}
