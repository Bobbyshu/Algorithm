package A_OnsiteClassical.Tiktok;

import java.util.HashSet;
import java.util.Set;

public class NO1593_SplitMaxNumberUniqueSubstring {
  int res = 0;

  public int maxUniqueSplit(String s) {
    Set<String> set = new HashSet<>();
    dfs(s, 0, set);
    return res;
  }

  private void dfs(String s, int pos, Set<String> set) {
    if (s.length() - pos + set.size() <= res) {
      return;
    }

    if (pos == s.length()) {
      res = Math.max(res, set.size());
      return;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = pos; i < s.length(); ++i) {
      sb.append(s.charAt(i));
      String cur = sb.toString();
      if (!set.contains(cur)) {
        set.add(cur);
        dfs(s, i + 1, set);
        set.remove(cur);
      }
    }
  }
}
