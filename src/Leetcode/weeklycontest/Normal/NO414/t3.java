package Leetcode.weeklycontest.Normal.NO414;

import java.util.List;

public class t3 {
  public long findMaximumScore(List<Integer> nums) {
    long res = 0L;
    int max = nums.get(0), maxIdx = 0;
    for (int i = 1; i < nums.size(); ++i) {
      if (nums.get(i) <= max) {
        continue;
      }

      res += (long) max * (i - maxIdx);
      max = nums.get(i);
      maxIdx = i;
    }

    if (maxIdx != nums.size() - 1) {
      res += (long) max * (nums.size() - 1 - maxIdx);
    }

    return res;
  }
}
