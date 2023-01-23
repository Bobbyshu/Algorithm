package leetcode.weeklycontest.DOUBLE.NO96;

import java.util.Arrays;

public class t2 {
  public long minOperations(int[] nums1, int[] nums2, int k) {
    if (k == 0) {
      return Arrays.equals(nums1, nums2) ? 0 : -1;
    }
    long res = 0L, sum1 = 0L, sum2 = 0L, gap = 0L;
    int n = nums1.length;
    for (int i = 0; i < n; ++i) {
      sum1 += nums1[i];
      sum2 += nums2[i];
      if (Math.abs(nums1[i] - nums2[i]) % k != 0) {
        return -1;
      }
      gap += Math.abs(nums1[i] - nums2[i]);
    }

    if (sum1 != sum2) {
      return -1;
    }

    return gap / (2 * k);
  }
}
