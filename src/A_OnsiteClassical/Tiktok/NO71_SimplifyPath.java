package A_OnsiteClassical.Tiktok;

import java.util.ArrayDeque;
import java.util.Deque;

public class NO71_SimplifyPath {
  public String simplifyPath(String path) {
    Deque<String> stack = new ArrayDeque<>();
    int n = path.length();

    for (int i = 1; i < n; ) {
      if (path.charAt(i) == '/') {
        ++i;
        continue;
      }
      int j = i + 1;
      while (j < n && path.charAt(j) != '/') {
        j++;
      }
      String item = path.substring(i, j);
      if (item.equals("..")) {
        if (!stack.isEmpty()) stack.pollLast();
      } else if (!item.equals(".")) {
        stack.addLast(item);
      }
      i = j;
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append("/").append(stack.pollFirst());
    }

    return sb.isEmpty() ? "/" : sb.toString();
  }
}
