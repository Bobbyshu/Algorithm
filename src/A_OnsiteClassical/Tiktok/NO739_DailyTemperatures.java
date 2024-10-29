package A_OnsiteClassical.Tiktok;

import java.util.ArrayDeque;
import java.util.Deque;

public class NO739_DailyTemperatures {

  public int[] dailyTemperatures(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];
    Deque<int[]> stack = new ArrayDeque<>();
    stack.addLast(new int[]{nums[n - 1], n - 1});

    for (int i = n - 2; i >= 0; --i) {
      // equals also should be poll out
      while (!stack.isEmpty() && nums[i] >= stack.peekLast()[0]) {
        stack.pollLast();
      }

      res[i] = stack.isEmpty() ? 0 : stack.peekLast()[1] - i;
      stack.addLast(new int[]{nums[i], i});
    }

    return res;
  }

}
