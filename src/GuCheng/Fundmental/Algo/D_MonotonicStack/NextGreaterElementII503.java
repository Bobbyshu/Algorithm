package GuCheng.Fundmental.Algo.D_MonotonicStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElementII503 {
  public int[] nextGreaterElements(int[] nums) {
    Deque<Integer> stack = new ArrayDeque<>();

    int n = nums.length;
    int[] res = new int[n];
    Arrays.fill(res,-1);

    int j = 0;
    //正向遍历，把下标存进去，如果有大于栈顶下标的，那就可以把栈顶那些比他小的都拿出来标记为当前那个比他们大的数字了
    for (int i = 0; i < 2 * n; ++i) {
      while (!stack.isEmpty() && nums[i % n] > nums[stack.peekLast()]) {
        j = stack.pollLast();
        res[j] = nums[i % n];
      }

      stack.addLast(i % n);
    }

    return res;
  }

  public int[] nextGreaterElementsReverse(int[] nums) {
    Deque<Integer> stack = new ArrayDeque<>();

    int n = nums.length;
    int[] res = new int[n];

    int j = 0;
    //正向遍历，把下标存进去，如果有大于栈顶下标的，那就可以把栈顶那些比他小的都拿出来标记为当前那个比他们大的数字了
    for (int i = 2 * n - 1; i >= 0; --i) {
      while (!stack.isEmpty() && nums[i % n] >= stack.peekLast()) {
        stack.pollLast();
      }
      res[i % n] = stack.isEmpty() ? -1 : stack.peekLast();
      stack.addLast(nums[i]);
    }

    return res;
  }
}
