package Leetcode.weeklycontest.Normal.NO336;

import java.util.HashMap;
import java.util.Map;

public class t3 {
  public long beautifulSubarrays(int[] nums) {
    long temp = 0, res = 0;
    Map<Long, Long> map = new HashMap<>();
    map.put(0L, 1L);
    for (int num : nums) {
      temp ^= num;
      if (map.containsKey(temp)) {
        res += map.get(temp);
        map.put(temp, map.get(temp) + 1);
      } else {
        map.put(temp, 1L);
      }
    }
    return res;
  }
}
