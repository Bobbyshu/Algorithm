package Leetcode.weeklycontest.DOUBLE.NO98;

import java.util.HashSet;
import java.util.Set;

public class t3 {
  public int minImpossibleOR(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int n : nums) {
      set.add(n);
    }

    for (int i = 1; true; i *= 2) {
      if (!set.contains(i)) {
        return i;
      }
    }

  }
}
