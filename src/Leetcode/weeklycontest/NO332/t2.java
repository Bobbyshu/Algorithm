package Leetcode.weeklycontest.NO332;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class t2 {
  public static void main(String[] args) {

  }
  public static long countFairPairs(int[] nums, int lower, int upper) {
    long res = 0L;
    int n = nums.length;

    Arrays.sort(nums);
    for (int i = 0; i < n; ++i) {
      int l = i + 1, r = n - 1;
      int j = l, k = r;
      while (l < r) {
        int mid = (r - l + 1) / 2 + l;
        if (nums[i] + nums[mid] <= upper) {
          l = mid;
        } else {
          r = mid - 1;
          k = mid - 1;
        }
      }
      l = i + 1;
      r = n - 1;
      while (l < r) {
        int mid = (r - l) / 2 + l;
        if (nums[i] + nums[mid] >= upper) {
          r = mid;
        } else {
          l = mid + 1;
          j = mid + 1;
        }
      }
      res += k - j + 1;
    }
    return res;
  }
}
