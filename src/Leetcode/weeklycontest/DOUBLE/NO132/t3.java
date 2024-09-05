package Leetcode.weeklycontest.DOUBLE.NO132;

import java.util.Arrays;

public class t3 {
  public int maximumLength(int[] nums, int k) {
    int n = nums.length;
    // dp[i][j] states that the longest length of subarray
    // that ends with nums[i] and no more than j index satisfied
    // here k don't need to divided by 2 cuz we have taken it account during computation
    int[][] dp = new int[n][k + 1];

    for (int[] d : dp) {
      Arrays.fill(d, 1);
    }

    // System.out.println(Arrays.deepToString(dp));

    int res = 0;

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j <= k; ++j) {
        for (int p = 0; p < i; ++p) {
          // we can set nums[i] as the new
          if (j == 0) {
            if (nums[p] == nums[i]) {
              dp[i][j] = Math.max(dp[i][j], dp[p][j] + 1);
            }
            continue;
          }

          // if equals, we can transfer directly
          if (nums[p] == nums[i]) {
            dp[i][j] = Math.max(dp[i][j], dp[p][j] + 1);
          } else { // else we need to transfer from k - 1
            dp[i][j] = Math.max(dp[i][j], dp[p][j - 1] + 1);
          }
        }

        res = Math.max(res, dp[i][j]);
      }
      // res = Math.max(res, dp[i][j]);
    }

    // System.out.println(Arrays.deepToString(dp));

    return res;
  }
}
