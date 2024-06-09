package Leetcode.weeklycontest.Normal.NO401;

import java.util.Arrays;

public class t3 {
  // 1 2 3 4 6
  // 1 3 4 7 10
  // [-2147483648, 1, -2147483648, -2147483648]
  // [-2147483648, 1, 2, -2147483647]
  // [-2147483648, -2147483648, -2147483648, 3]
  // [-2147483648, -2147483648, -2147483648, 3]
  public int maxTotalReward(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length, max = 0;
    for (int num : nums) {
      max = Math.max(max, num);
    }
    boolean[][] dp = new boolean[n][2 * max];
    // for (int[] d : dp) {
    //     Arrays.fill(d, Integer.MIN_VALUE);
    // }
    dp[0][0] = true;
    dp[0][nums[0]] = true;

    for (int i = 1; i < n; ++i) {
      // dp[i][nums[i]] = true;
      for (int j = 0; j < 2 * max; ++j) {
        dp[i][j] = dp[i - 1][j];
        if (j >= nums[i] && j - nums[i] < nums[i]) {
          dp[i][j] |= dp[i - 1][j - nums[i]];
        }
      }
    }

    // System.out.println(Arrays.deepToString(dp));
    int res = 0;
    for (int i = 0; i < 2 * max; ++i) {
      if (dp[n - 1][i]) {
        res = Math.max(res, i);
      }
    }
    return res;
  }
}
