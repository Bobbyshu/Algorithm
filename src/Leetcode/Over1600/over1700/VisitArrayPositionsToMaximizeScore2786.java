package Leetcode.Over1600.over1700;

public class VisitArrayPositionsToMaximizeScore2786 {
  public long maxScore(int[] nums, int x) {
    int n = nums.length;
    // dp[i][0] states that for ith numbers maximum score can get when ith number is even
    // dp[i][0] states that for ith numbers maximum score can get when ith number is odd
    long[][] dp = new long[n][2];

    // we need to set another one as -x
    // because we take credit of cost by default
    if (nums[0] % 2 == 0) {
      dp[0][0] = nums[0];
      dp[0][1] = -x;
    } else {
      dp[0][0] = -x;
      dp[0][1] = nums[0];
    }

    long res = Math.max(dp[0][0], dp[0][1]);

    for (int i = 1; i < n; ++i) {
      if (nums[i] % 2 == 0) {
        dp[i][0] = Math.max(dp[i - 1][1] + nums[i] - x, dp[i - 1][0] + nums[i]);
        // it means we don't choose current one
        // we can only extend last number
        dp[i][1] = dp[i - 1][1];
      } else {
        dp[i][0] = dp[i - 1][0];
        dp[i][1] = Math.max(dp[i - 1][0] + nums[i] - x, dp[i - 1][1] + nums[i]);
      }
    }

    // System.out.println(Arrays.deepToString(dp));

    return Math.max(dp[n - 1][0], dp[n - 1][1]);
  }
}
