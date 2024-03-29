package GuCheng.Fundmental.Algo.D_MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater42 {
  public static void main(String[] args) {
    int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    trap(arr);
  }

  public static int trap(int[] height) {
    int sum = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    int current = 0;
    while (current < height.length) {
      //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
      while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
        int h = height[stack.peek()]; //取出要出栈的元素
        stack.pop(); //出栈
        if (stack.isEmpty()) { // 栈空就出去
          break;
        }
        int distance = current - stack.peek() - 1; //两堵墙之前的距离。
        int min = Math.min(height[stack.peek()], height[current]);
        sum = sum + distance * (min - h);
      }
      stack.push(current); //当前指向的墙入栈
      current++; //指针后移
    }
    return sum;
  }
}
