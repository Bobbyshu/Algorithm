package Math;

import java.util.Arrays;
import java.util.Collections;


public class test2 {
  public static void main(String[] args) {
    int[] arr = {1,2,3};
    Arrays.sort(arr);
  }

  public static int longestNiceSubarray(int[] nums) {
    int n = nums.length, res = 1;
    for (int i = 31; i >= 1; --i) {
      for (int j = 0; j < n - i; ++j) {
        if (check(nums, j, j + i)) {
          res = Math.max(res, i + 1);
        }
      }
    }
    return res;
  }

 static boolean check(int[] nums, int i, int j) {
    for (; i <= j; ++i) {
      for (int k = i + 1; k <= j; ++k) {
        if ((nums[i] & nums[k]) != 0) {
          return false;
        }
      }
    }
    return true;
  }
}
