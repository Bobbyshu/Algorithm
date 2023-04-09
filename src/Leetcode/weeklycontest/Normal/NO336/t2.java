package Leetcode.weeklycontest.Normal.NO336;

import java.util.Arrays;

public class t2 {
  public int maxScore(int[] nums) {
    Arrays.sort(nums);
    long sum = 0L;
    int res = 0;
    for (int i = nums.length - 1; i >= 0; --i) {
      sum += nums[i];
      if (sum <= 0) {
        break;
      }
      ++res;
    }
    return res;
  }
}
