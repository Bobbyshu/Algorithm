package Leetcode.weeklycontest.Normal.NO338;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t3 {
  public List<Long> minOperations(int[] nums, int[] queries) {
    Arrays.sort(nums);
    int n = nums.length;

    long[] prefix = new long[n + 1];
    for (int i = 1; i <= n; ++i) {
      prefix[i] = prefix[i - 1] + nums[i - 1];
    }

    List<Long> res = new ArrayList<>();
    for (int query : queries) {
      long cnt = 0;

      // lower bound
      int idx = Arrays.binarySearch(nums, query);
      if (idx < 0) {
        idx = -idx - 1;
      }

      cnt += (long) idx * query - prefix[idx];

      cnt += prefix[n] - prefix[idx] - (long) (n - idx) * query;

      res.add(cnt);
    }

    return res;
  }
}
