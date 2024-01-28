package Leetcode.weeklycontest.Normal.NO382;

import java.util.HashMap;
import java.util.Map;

public class T2 {
  public static void main(String[] args) {
    int[] nums = {5,4,1,2,2};
    maximumLength(nums);
  }
  public static int maximumLength(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int n : nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }

    // System.out.println(map);

    Integer one = map.remove(1);
    int res = one != null ? one - (one % 2 ^ 1) : 0;

    for (int v : map.keySet()) {

      int cnt = 0;

      while (map.getOrDefault(v, 0) > 1) {
        cnt += 2;
        v *= v;
      }

      // check last one
      // exist + 1
      // non-exist backtrace to last two -> -1
      res = Math.max(res, cnt + (map.containsKey(v) ? 1 : -1));

    }

    return res;
  }
}
