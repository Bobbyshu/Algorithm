package Leetcode.weeklycontest.Normal.NO340;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class t2 {
  public long[] distance(int[] nums) {
    int n = nums.length;
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (!map.containsKey(nums[i])) {
        map.put(nums[i], new ArrayList<>());
      }
      map.get(nums[i]).add(i);
    }

    long[] res = new long[n];
    for (int value : map.keySet()) {
      List<Integer> list = map.get(value);
      long[] arr = getArray(list);
      for (int i = 0; i < list.size(); ++i) {
        int idx = list.get(i);
        res[idx] = arr[i];
      }
    }
    return res;
  }

  long[] getArray(List<Integer> list) {
    int n = list.size();
    long[] prefix = new long[n + 1];
    long[] res = new long[n];

    for (int i = 1; i <= n; ++i) {
      prefix[i] = prefix[i - 1] + list.get(i - 1);
    }

    for (int i = 1; i <= n; ++i) {
      long right = prefix[n] - prefix[i - 1];
      long left = prefix[i - 1];
      long leftGap = (long) (i - 1) * list.get(i - 1) - left;
      long rightGap = right - (long) (n - i + 1) * list.get(i - 1);
      res[i - 1] = leftGap + rightGap;
    }

    return res;
  }
}
