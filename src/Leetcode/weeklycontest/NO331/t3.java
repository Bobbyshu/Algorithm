package Leetcode.weeklycontest.NO331;

import java.util.Arrays;
import java.util.HashSet;

public class t3 {
  public int minCapability(int[] nums, int k) {
    if (k == (nums.length + 1) / 2) {
      int res = 0;
      for (int i = 0; i < nums.length; i += 2) {
        res = Math.max(res, nums[i]);
      }
      return res;
    }

    int res = Integer.MAX_VALUE, n = nums.length;
    int[][] arr = new int[n][2];
    for (int i = 0; i < n; ++i) {
      arr[i][0] = nums[i];
      arr[i][1] = i;
    }

    Arrays.sort(arr, ((o1, o2) -> o1[0] - o2[0]));


    for (int i = 0; i < n; ++i) {
      HashSet<Integer> set = new HashSet<>();
      int temp = k;
      int cnt = arr[i][0];
      set.add(arr[i][1] + 1);
      set.add(arr[i][1] - 1);
      --temp;
      for (int j = i + 1; j < n; ++j) {
        if (set.contains(arr[j][1])) {
          continue;
        }
        cnt = arr[j][0];
        set.add(arr[j][1] + 1);
        set.add(arr[j][1] - 1);
        --temp;
        if (temp == 0) {
          break;
        }
      }
      res = Math.min(res, cnt);
    }

    return res;
  }
}
