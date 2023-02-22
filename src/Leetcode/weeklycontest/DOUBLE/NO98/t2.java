package Leetcode.weeklycontest.DOUBLE.NO98;

import java.util.Arrays;
//1 4 5 7 8 9
public class t2 {
  public int minimizeSum(int[] nums) {
    int n = nums.length;
    if (n <= 3) {
      return 0;
    }

    Arrays.sort(nums);
    int thirdMax = nums[n - 3], thirdMin = nums[2];
    int secondMax = nums[n - 2], secondMin = nums[1];
    int max = nums[n - 1], min = nums[0];

    int res = Integer.MAX_VALUE;
    for (int i = 0; i < n - 1; ++i) {
      res = Math.min(res, nums[n - 1] + nums[i + 1] - nums[i]);
    }

    // plus two minimum
    res = Math.min(res, Math.abs(max - thirdMin));
    // minus two maximum
    res = Math.min(res, Math.abs(thirdMax - min));
    // plus minimum and minus maximum
    res = Math.min(res, Math.abs(secondMax - secondMin));

    return res;
  }
}
