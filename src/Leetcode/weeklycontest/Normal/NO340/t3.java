package Leetcode.weeklycontest.Normal.NO340;

import java.util.Arrays;

public class t3 {
  // min -> left boundary
  public int minimizeMax(int[] nums, int p) {
    int n = nums.length;
    Arrays.sort(nums);
    int l = 0, r = (int) 1e9;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (check(nums, mid, p)) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }

  boolean check(int[] nums, int target, int p) {
    int i = 0, n = nums.length;
    while (i < n) {
      if (i + 1 < n && nums[i + 1] - nums[i] <= target) {
        --p;
        i += 2;
      } else {
        ++i;
      }
      if (p < 0) {
        return true;
      }
    }

    return p <= 0;
  }
}
