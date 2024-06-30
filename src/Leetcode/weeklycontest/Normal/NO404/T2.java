package Leetcode.weeklycontest.Normal.NO404;

public class T2 {
  public int maximumLength(int[] nums) {
    int n = nums.length;
    int odd = 0, even = 0;
    for (int num : nums) {
      if (num % 2 == 0) {
        ++even;
      } else {
        ++odd;
      }
    }
    int res = Math.max(odd, even);
    if (res == n) {
      return n;
    }


    int[][] dp = new int[n][2];
    // symbolize 3 way
    // full odd
    // full even
    // odd even traverse

    if (nums[0] % 2 == 0) {
      dp[0][0] = 1;
    } else {
      dp[0][1] = 1;
    }

    for (int i = 1; i < n; ++i) {
      if (nums[i] % 2 == 0) {
        dp[i][0] = dp[i - 1][1] + 1;
        dp[i][1] = dp[i - 1][1];
      } else {
        dp[i][1] = dp[i - 1][0] + 1;
        dp[i][0] = dp[i - 1][0];
      }
    }


    // System.out.println(Arrays.deepToString(dp));
    return Math.max(res, Math.max(dp[n - 1][0], dp[n - 1][1]));
  }
}
