package Leetcode.weeklycontest.DOUBLE.NO137;

import java.util.Arrays;

public class t2 {
  public int[] resultsArray(int[] nums, int k) {
    int n = nums.length;
    int[] res = new int[n - k + 1];
    Arrays.fill(res, -1);

    int cntCons = 0;
    for (int i = 0; i < n; ++i) {
      if (i == 0 || nums[i] == nums[i - 1] + 1) {
        ++cntCons;
      } else {
        cntCons = 1;
      }

      if (cntCons >= k) {
        res[i - k + 1] = nums[i];
      }
    }

    return res;
  }
}
