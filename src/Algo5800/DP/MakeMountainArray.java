package Algo5800.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    int n = nums.length;
    int[] suf = new int[n];
    List<Integer> g = new ArrayList<>();
    for (int i = n - 1; i > 0; i--) {
      int x = nums[i];
      int j = lowerBound(g, x);
      if (j == g.size()) {
        g.add(x);
      } else {
        g.set(j, x);
      }
      suf[i] = j + 1;
    }

    int mx = 0;
    g.clear();
    for (int i = 0; i < n - 1; i++) {
      int x = nums[i];
      int j = lowerBound(g, x);
      if (j == g.size()) {
        g.add(x);
      } else {
        g.set(j, x);
      }
      int pre = j + 1;
      if (pre >= 2 && suf[i] >= 2) {
        mx = Math.max(mx, pre + suf[i] - 1);
      }
    }
    return n - mx;
  }

  private int lowerBound(List<Integer> g, int target) {
    int left = 0, right = g.size();
    while (left < right) {
      int mid = (left + right) >>> 1;
      if (g.get(mid) < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return right;
  }
}
