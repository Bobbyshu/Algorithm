package A_OnsiteClassical.grind75;

import java.util.ArrayDeque;
import java.util.Deque;

public class minStack {
  Deque<int[]> stk;

  public minStack() {
    stk = new ArrayDeque<>();
  }

  public void push(int val) {
    if (stk.isEmpty()) {
      stk.add(new int[]{val, val});
    } else {
      stk.add(new int[]{val, Math.min(val, stk.peekLast()[1])});
    }
  }

  public void pop() {
    stk.pollLast();
  }

  public int top() {
    return stk.peekLast()[0];
  }

  public int getMin() {
    return stk.peekLast()[1];
  }
}
