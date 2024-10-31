package A_OnsiteClassical.Tiktok;

import java.util.ArrayDeque;
import java.util.Deque;

public class NO224_BasicCalculator {
  public int calculate(String s) {
    Deque<Integer> stk = new ArrayDeque<>();
    stk.addLast(1);
    int sign = 1;

    int res = 0, n = s.length(), i = 0;

    while (i < n) {
      if (s.charAt(i) == ' ') {
        ++i;
      } else if (s.charAt(i) == '+') {
        sign = stk.peekLast();
        ++i;
      } else if (s.charAt(i) == '-') {
        sign = -stk.peekLast();
        ++i;
      } else if (s.charAt(i) == '(') {
        stk.addLast(sign);
        ++i;
      } else if (s.charAt(i) == ')') {
        stk.pollLast();
        ++i;
      } else {
        long num = 0L;
        while (i < n && Character.isDigit(s.charAt(i))) {
          num = num * 10 + s.charAt(i) - '0';
          ++i;
        }
        res += sign * num;
      }
    }

    return res;
  }
}
