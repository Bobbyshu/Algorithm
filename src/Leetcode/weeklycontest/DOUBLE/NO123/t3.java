package Leetcode.weeklycontest.DOUBLE.NO123;

import java.util.HashMap;
import java.util.Map;

public class t3 {
  // maximum sum -> prefix sum -> O(1) got nums[i] to nums[j]
  // we have to got the i and j in O(n) / O(nlogN)
  //   -1 3 2 4 5
  // 0 -1 2 4 8 13
  // enumerate J to get minimum I
  // to satisfied prefix[j+1] - prefix[i] Maximum -> prefix[i] should be minimum
  //
  public long maximumSubarraySum(int[] nums, int k) {
    long res = Long.MIN_VALUE;

    long sum = 0L;
    Map<Integer, Long> minSum = new HashMap<>();
    for (int n : nums) {
      long s1 = minSum.getOrDefault(n - k, Long.MAX_VALUE / 2);
      long s2 = minSum.getOrDefault(n + k, Long.MAX_VALUE / 2);
      res = Math.max(res, sum + n - Math.min(s1, s2));
      // trace the minimumSum of specific number
      if (!minSum.containsKey(n) || sum < minSum.get(n)) {
        minSum.put(n, sum);
      }
      sum += n;
    }

    // if no legal answer
    // sum + n - MAX /2 -> MIN + N - MAX /2  -> MIN / 2 + N ->
    return res > Long.MIN_VALUE / 4 ? res : 0;
  }
}
