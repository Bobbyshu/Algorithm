package A_OnsiteClassical.Tiktok;

import java.util.ArrayDeque;
import java.util.Deque;

public class NO227_BasicCalculatorII {
  public int calculate(String s) {
    Deque<Integer> stack = new ArrayDeque<>();
    char sign = '+';
    int cur = 0;

    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        cur = cur * 10 + (c - '0');
      }

      if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
        if (sign == '+') {
          stack.addLast(cur);
        } else if (sign == '-') {
          stack.addLast(-cur);
        } else if (sign == '*') {
          stack.add(cur * stack.pollLast());
        } else {
          stack.add(stack.pollLast() / cur);
        }
        cur = 0;
        sign = c;
      }
    }

    int res = 0;
    while (!stack.isEmpty()) {
      res += stack.pollLast();
    }

    return res;
  }
}
