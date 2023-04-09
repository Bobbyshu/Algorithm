package Leetcode.weeklycontest.DOUBLE.NO101;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class t1 {
  public int minNumber(int[] nums1, int[] nums2) {
    Set<Integer> set = new HashSet<>();
    for (int n : nums1) {
      set.add(n);
    }
    int res = Integer.MAX_VALUE;
    for (int n : nums2) {
      if (set.contains(n)) {
        res = Math.min(res, n);
      }
    }
    if (res != Integer.MAX_VALUE) {
      return res;
    }

    Arrays.sort(nums1);
    Arrays.sort(nums2);

    return Math.min(nums1[0], nums2[0]) * 10 + Math.max(nums1[0], nums2[0]);
  }
}
