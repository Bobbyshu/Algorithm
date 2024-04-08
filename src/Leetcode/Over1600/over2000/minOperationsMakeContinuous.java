package Leetcode.Over1600.over2000;

import java.util.*;

public class minOperationsMakeContinuous {
  // leetcode 2009
  // First remove duplicate elements and sort the array because sequence doesn't make sense
  // Then try to find the most number we can hold
  // which means we can find the least number we can change(n - hold)
  // when we sort the array we can find the longest subarray we can hold
  // sliding window to find the [r - n + 1, r]
  public int minOperations(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int n : nums) {
      set.add(n);
    }

    List<Integer> lst = new ArrayList<>(set);
    Collections.sort(lst);

    // System.out.println(lst);

    int l = 0, r = 0, n = nums.length;
    int hold = 0;

    //   [r-n+1  ,r]
    while (r < lst.size()) {

      while (l < r && lst.get(l) < lst.get(r) - n + 1) {
        ++l;
      }

      hold = Math.max(hold, r - l + 1);

      ++r;
    }
    // System.out.println(keep);

    return n - hold;
  }
}
