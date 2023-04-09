package Leetcode.weeklycontest.Normal.NO334;

import java.util.Arrays;

public class t3 {
  public int maxNumOfMarkedIndices(int[] nums) {
    Arrays.sort(nums);
    int l = 0, r = nums.length / 2;

    while (l <= r) {
      int mid = (l + r) / 2;
      if (check(nums, mid)) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return 2 * r;
  }

  boolean check(int[] nums, int k) {
    for (int i = 0; i < k; ++i)
      if (nums[i] * 2 > nums[nums.length - k + i]) {
        return false;
      }
    return true;
  }
}
