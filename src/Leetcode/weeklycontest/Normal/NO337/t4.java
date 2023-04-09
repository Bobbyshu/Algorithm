package Leetcode.weeklycontest.Normal.NO337;

import java.util.Arrays;

public class t4 {
  public int findSmallestInteger(int[] nums, int value) {
    Arrays.sort(nums);
    int lo = 0, hi = nums.length + 1;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (check(nums, value, mid)) {
        lo = mid + 1;
      } else {
        hi = mid;
      }
    }
    return lo - 1;

  }

  private boolean check(int[] nums, int value, int mid) {
    int target = 0;
    for (int i = 0; i < mid; i++) {
      if (nums[i] - target >= 0 && nums[i] - target <= value) {
        target = nums[i] + value + 1;
      }
    }
    return target <= nums[mid];
  }
}
