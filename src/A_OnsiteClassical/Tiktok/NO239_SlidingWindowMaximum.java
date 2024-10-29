package A_OnsiteClassical.Tiktok;

import java.util.ArrayDeque;
import java.util.Deque;

public class NO239_SlidingWindowMaximum {
  // 用一个单调队列的顶部来记录当前的最大值
  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    int[] res = new int[n - k + 1];
    Deque<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < k; ++i) {
      while (!q.isEmpty() && q.peekLast() < nums[i]) {
        q.pollLast();
      }
      q.addLast(nums[i]);
    }

    res[0] = q.peekFirst();

    for (int i = k; i < n; ++i) {
      if (q.peekFirst() == nums[i - k]) {
        q.pollFirst();
      }

      while (!q.isEmpty() && q.peekLast() < nums[i]) {
        q.pollLast();
      }
      q.addLast(nums[i]);
      res[i - k + 1] = q.peekFirst();
    }

    return res;
  }
}
