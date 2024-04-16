package Leetcode.weeklycontest.DOUBLE.NO128;

import java.util.ArrayDeque;
import java.util.Deque;

public class t4 {
  // subarray general solving method
  // enumerate right side
  // monotonous stack
  // we only need to find a decreasing array
  // 4 3 3 1 3 1
  // when we traverse to last 1
  // we can pop first 1 because there're 3 larger than 1
  // which means that 1 can never be count as result array
  public long numberOfSubarrays(int[] nums) {
    long res = nums.length;
    Deque<int[]> stk = new ArrayDeque<>();
    stk.push(new int[]{Integer.MAX_VALUE, 0});
    for (int n : nums) {
      while (n > stk.peekLast()[0]) {
        stk.pollLast();
      }

      if (n == stk.peekLast()[0]) {
        res += stk.peekLast()[1];
        stk.peekLast()[1]++;
      } else {
        stk.addLast(new int[]{n, 1});
      }
    }
    return res;
  }
}
