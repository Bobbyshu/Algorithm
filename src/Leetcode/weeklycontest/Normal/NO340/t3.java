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
      int i = 0, cnt = 0;
      while (i < n) {
        if (i + 1 < n && nums[i + 1] - nums[i] <= mid) {
          cnt++;
          i += 2;
        } else {
          i++;
        }
      }
      if (cnt >= p) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }
}
