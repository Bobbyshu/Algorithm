package GuCheng.Fundmental.Algo.D_MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram84 {
  public int largestRectangleArea(int[] heights) {
    Deque<Integer> stack = new ArrayDeque<>();
    int res = 0;
    int[] arr = new int[heights.length + 2];
    for (int i = 1; i <= heights.length; ++i) {
      arr[i] = heights[i - 1];
    }
    for (int i = 0; i < arr.length; ++i) {
      while (!stack.isEmpty() && arr[i] < arr[stack.peekLast()]) {
        int j = stack.pollLast();
        int left = stack.peekLast() + 1;
        int right = i - 1;
        res = Math.max(res, arr[j] * (right - left + 1));
      }

      stack.addLast(i);
    }
    return res;
  }
}
