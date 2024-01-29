package Leetcode.weeklycontest.Normal.NO376;

import java.util.Arrays;

public class T2 {
  public int[][] divideArray(int[] nums, int k) {
    Arrays.sort(nums);
    int n = nums.length;
    int[][] res = new int[n / 3][3];

    for (int i = 2; i < n; i += 3) {
      if (nums[i] - nums[i - 2] > k) {
        return new int[][]{};
      }
      res[i / 3] = new int[]{nums[i - 2], nums[i - 1], nums[i]};
    }

    return res;
  }
}
