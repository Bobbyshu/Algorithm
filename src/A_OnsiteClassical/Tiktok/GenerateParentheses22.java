package A_OnsiteClassical.Tiktok;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Space Complexity: O(N) we only use 1 container to accommodate the string
// Time Complexity: O(2
public class GenerateParentheses22 {
  StringBuilder sb;
  List<String> res;
  int n;

  public List<String> generateParenthesis(int n) {
    sb = new StringBuilder();
    res = new ArrayList<>();
    this.n = n;

    dfs(0);
    return res;
  }

  private void dfs(int idx) {
    if (idx == 2 * n) {
      if (check(sb.toString())) {
        res.add(sb.toString());
      }
      return;
    }

    int curLength = sb.length();
    sb.append('(');
    dfs(idx + 1);
    sb.setLength(curLength);

    sb.append(')');
    dfs(idx + 1);
    sb.setLength(curLength);
  }

  private boolean check(String s) {
    int left = 0;
    for (char c : s.toCharArray()) {
      if (c == '(') {
        ++left;
      } else {
        if (left == 0) {
          return false;
        } else {
          --left;
        }
      }
    }

    return left == 0;
  }

  public List<String> generateParenthesisOptimize(int n) {
    res = new LinkedList<>();
    backtrace(new StringBuilder(), n, n);
    return res;
  }

  void backtrace(StringBuilder sb, int left, int right) {
    if (left > right) return;
    if (left < 0 || right < 0) return;

    if (left == 0 && right == 0) {
      res.add(sb.toString());
      return;
    }

    sb.append("(");
    backtrace(sb, left - 1, right);
    sb.deleteCharAt(sb.length() - 1);

    sb.append(")");
    backtrace(sb, left, right - 1);
    sb.deleteCharAt(sb.length() - 1);
  }
}
