package Leetcode.weeklycontest.Normal.NO403;

import java.util.Arrays;

public class t3 {
  public long maximumTotalCost(int[] nums) {
    int n = nums.length;
    long[][] dp = new long[n][2];
    // dp states that the largest prefix with ith as end
    // 0 -> positive
    // 1 -> negative
    for (long[] d : dp) {
      Arrays.fill(d, Integer.MIN_VALUE);
    }
    dp[0][0] = nums[0];

    for (int i = 1; i < n; ++i) {
      dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]) + nums[i];
      dp[i][1] = dp[i - 1][0] - nums[i];
    }

    return Math.max(dp[n - 1][0], dp[n - 1][1]);
  }
}
