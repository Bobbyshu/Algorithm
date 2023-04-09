package Leetcode.weeklycontest.DOUBLE.NO100;

import java.util.Arrays;
import java.util.PriorityQueue;

public class t2 {
  public int maximizeGreatness(int[] nums) {
    int n = nums.length;
    Arrays.sort(nums);
    // 1 1 1 2 3 3 5

    int[] arr = Arrays.copyOf(nums, n);
    int l = 0, r = n - 1, res = 0;
    for (int i = n - 1; i >= 0; --i) {
      if (nums[i] < arr[r] && r >= l) {
        ++res;
        --r;
      } else {
        ++l;
      }
    }

    return res;
  }
}
