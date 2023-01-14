package GuCheng.Fundmental.Algo.D_MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures739 {
  public int[] dailyTemperatures(int[] temperatures) {
    int[] res = new int[temperatures.length];
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = temperatures.length - 1; i >= 0; --i) {
      while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peekLast()]) {
        stack.pollLast();
      }
      res[i] = stack.isEmpty() ? 0 : stack.peekLast() - i;
      stack.addLast(i);
    }
    return res;
  }
}
