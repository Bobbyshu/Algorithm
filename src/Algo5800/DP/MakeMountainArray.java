package Algo5800.DP;

import java.util.Arrays;

public class MakeMountainArray {
  // [2, 1, 1, 5, 6, 2, 3, 1]
  // [9, 8, 1, 7, 6, 5, 4, 3, 2, 1]
  // [100,92,89,77,74,66,64,66,64]
  // 变成山形状数组最少删除次数 => 找到最长的山形数组咯
  //
  public int minimumMountainRemovals(int[] nums) {
    int n = nums.length;
    int[] prefix = new int[n];
    Arrays.fill(prefix, 1);

    for (int i = 1; i < n - 1; ++i) {
      for (int j = 0; j < i; ++j) {
        if (nums[i] > nums[j]) {
          prefix[i] = Math.max(prefix[i], prefix[j] + 1);
        }
      }
    }

    int[] suffix = new int[n];
    Arrays.fill(suffix, 1);

    for (int i = n - 2; i >= 0; --i) {
      for (int j = n - 1; j > i; --j) {
        if (nums[i] > nums[j]) {
          suffix[i] = Math.max(suffix[i], suffix[j] + 1);
        }
      }
    }

    // System.out.println(Arrays.toString(prefix));
    // System.out.println(Arrays.toString(suffix));

    int res = 0;
    for (int i = 1; i < n - 1; ++i) {
      if (prefix[i] > 1 && suffix[i] > 1) {
        res = Math.max(res, prefix[i] + suffix[i]);
      }
    }

    res--;
    // System.out.println(res);
    // System.out.println(pivot);
    return n - res;
  }

  public int binarySearch(int[] nums) {

  }
}
