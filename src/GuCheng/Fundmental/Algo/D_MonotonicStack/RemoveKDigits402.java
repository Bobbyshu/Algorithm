package GuCheng.Fundmental.Algo.D_MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits402 {
  public String removeKdigits(String num, int k) {
    Deque<Character> stack = new ArrayDeque<>();
    if (num.length() == k)
      return "0";
    for (char ch : num.toCharArray()) {
      while (k > 0 && !stack.isEmpty() && ch < stack.peekLast()) {
        stack.pollLast();
        k--;
      }
      //avoid leading zero
      //only push char when stack is empty
      //or the char isn't zero when the stack is empty
      if (ch != '0' || !stack.isEmpty())
        stack.addLast(ch);
    }

    //avoid all the char is increasing
    //let k -> 0
    while (k > 0 && !stack.isEmpty()) {
      stack.pollLast();
      k--;
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.poll());
    }

    // avoid return ""
    return sb.length() == 0 ? "0" : sb.toString();
  }
}
