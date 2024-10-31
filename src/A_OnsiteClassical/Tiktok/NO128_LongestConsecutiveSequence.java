package A_OnsiteClassical.Tiktok;

import java.util.HashSet;
import java.util.Set;

public class NO128_LongestConsecutiveSequence {
  public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int n : nums) {
      set.add(n);
    }

    int res = 0;
    for (int num : nums) {
      if (!set.contains(num - 1)) {
        int cur = num, curLen = 1;
        while (set.contains(cur + 1)) {
          ++cur;
          ++curLen;
        }

        res = Math.max(res, curLen);
      }
    }

    return res;
  }
}
