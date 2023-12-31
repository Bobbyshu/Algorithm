package A_OnsiteClassical.backtrace;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
  List<List<String>> res;
  List<String> path;

  public List<List<String>> partition(String s) {
    res = new ArrayList<>();
    path = new ArrayList<>();;

    dfs(s, 0);
    return res;
  }

  void dfs(String s, int startIdx) {
    if (startIdx >= s.length()) {
      res.add(new ArrayList<>(path));
      return;
    }

    for (int i = startIdx; i < s.length(); ++i) {
      if (check(s, startIdx, i)) {
        String cur = s.substring(startIdx, i + 1);
        path.add(cur);
      } else {
        continue;
      }

      dfs(s, i + 1);
      path.remove(path.size() - 1);
    }
  }

  boolean check(String s, int i, int j) {
    while (i < j) {
      if (s.charAt(i++) != s.charAt(j--)) {
        return false;
      }
    }

    return true;
  }
}
