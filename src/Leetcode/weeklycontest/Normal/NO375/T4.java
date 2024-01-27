package Leetcode.weeklycontest.Normal.NO375;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T4 {
  public int numberOfGoodPartitions(int[] nums) {
    Map<Integer, int[]> map = new HashMap<>();
    int n = nums.length;

    for (int i = 0; i < n; ++i) {
      int cur = nums[i];
      if (map.containsKey(cur)) {
        map.get(cur)[1] = i;
      } else {
        // single element
        map.put(cur, new int[]{i, i});
      }
    }

    List<int[]> lst = new ArrayList<>(map.values());

    lst.sort((o1, o2) -> o1[0] - o2[0]);

    int res = 1, mod = (int) 1e9 + 7;
    int r = lst.get(0)[1];
    for (int[] i : lst) {
      int left = i[0], right = i[1];
      // no overlapping
      if (left > r) {
        // 2^(seg-1)
        res = res * 2 % mod;
      }
      r = Math.max(r, right);
    }

    return res;
  }
}
