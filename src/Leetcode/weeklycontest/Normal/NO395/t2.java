package Leetcode.weeklycontest.Normal.NO395;

import java.util.Arrays;

public class t2 {
  public int minimumAddedInteger(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);

    for (int i = 2; i > 0; --i) {
      int gap = nums2[0] - nums1[i];
      int j = 0;
      for (int k = i; k < nums1.length; ++k) {
        if (j < nums2.length && nums2[j] == nums1[k] + gap) {
          ++j;
          if (j == nums2.length) {
            return gap;
          }
        }
      }
    }
    return nums2[0] - nums1[0];
  }
}
