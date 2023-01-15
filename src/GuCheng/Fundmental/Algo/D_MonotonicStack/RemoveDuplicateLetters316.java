package GuCheng.Fundmental.Algo.D_MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicateLetters316 {
  public String removeDuplicateLetters(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    int[] cnt = new int[26];
    for (char c : s.toCharArray()) {
      ++cnt[c - 'a'];
    }

    boolean[] inStack = new boolean[26];

    for (char c : s.toCharArray()) {
      --cnt[c - 'a'];

      // remove duplicate
      if (inStack[c - 'a']) {
        continue;
      }
      // pop bigger lexi char
      while (!stack.isEmpty() && c < stack.peekLast()) {
        // means that that's the last one character in arr,
        // so we can't delete it
        if (cnt[stack.peekLast() - 'a'] == 0) {
          break;
        }
        inStack[stack.pollLast() - 'a'] = false;
      }

      stack.addLast(c);
      inStack[c - 'a'] = true;
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pollFirst());
    }

    return sb.toString();
  }
  /*
  // this version only consider the remove duplicate,
  // but it will delete when some char only appear once
  public String removeDuplicateLetters(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        boolean[] inStack = new boolean[26];

        for (char c : s.toCharArray()) {
            // remove duplicate
            if (inStack[c - 'a']) {
                continue;
            }
            // pop bigger lexi char
            while (!stack.isEmpty() && c < stack.peekLast()) {
                inStack[stack.pollLast() - 'a'] = false;
            }

            stack.addLast(c);
            inStack[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }

        return sb.toString();
    }


  // this version only consider the remove duplicate
  public String removeDuplicateLetters(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    boolean[] inStack = new boolean[26];

    for (char c : s.toCharArray()) {
      // remove duplicate
      if (inStack[c - 'a']) {
        continue;
      }
      stack.addLast(c);
      inStack[c - 'a'] = true;
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pollFirst());
    }

    return sb.toString();
  }

   */
}
