package Leetcode.weeklycontest.DOUBLE.NO102;

public class t2 {
  public long[] findPrefixScore(int[] nums) {
    int n = nums.length;

    // 2 3 7 7 10
    long[] max = new long[n];
    max[0] = nums[0];
    for (int i = 1; i < n; ++i) {
      max[i] = Math.max(max[i - 1], nums[i]);
    }
    // 0 2 5 12 19 29
    long[] maxPrefix = new long[n + 1];
    for (int i = 1; i <= n; ++i) {
      maxPrefix[i] = maxPrefix[i - 1] + max[i - 1];
    }

    // 0 2 5 12 17 27
    long[] prefix = new long[n + 1];
    for (int i = 1; i <= n; ++i) {
      prefix[i] = prefix[i - 1] + nums[i - 1];
    }

    long[] res = new long[n];
    for (int i = 0; i < n; ++i) {
      res[i] = prefix[i + 1] + maxPrefix[i + 1];
    }

    return res;
  }
}
