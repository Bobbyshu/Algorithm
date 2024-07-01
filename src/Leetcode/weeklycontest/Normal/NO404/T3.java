package Leetcode.weeklycontest.Normal.NO404;

public class T3 {
  public int maximumLength(int[] nums, int k) {
    int res = 0;
    // dp[x][y] states that the length of sequence
    // whose last two number module k is x and y
    // 2 3 2 3 2 3
    // if we confirm the first two number module k
    // then the odd index and even index number module k
    // should be confirmed
    // dp[x][y] should be dp[y][x] + 1
    // dp[2][3] should be dp[3][2] + 1
    int[][] dp = new int[k][k];

    for (int x : nums) {
      x %= k;
      for (int y = 0; y < k; y++) {
        dp[y][x] = dp[x][y] + 1;
        res = Math.max(res, dp[y][x]);
      }
    }
    return res;
  }

  public int maximumLengthV2(int[] nums, int k) {
    // enumerate the remainder
    // ex: if m == 5 we got the last number module k is 2
    // so the next one module k should be 3
    // which means dp[x] = dp[m - x] + 1 where x == nums[i] % k
    // to avoid negative number
    // we change to dp[x] = dp[(m - x + k) % k] + 1
    int res = 0;
    for (int m = 0; m < k; m++) {
      int[] dp = new int[k];
      for (int x : nums) {
        x %= k;
        dp[x] = dp[(m - x + k) % k] + 1;
        res = Math.max(res, dp[x]);
      }
    }
    return res;
  }

}
