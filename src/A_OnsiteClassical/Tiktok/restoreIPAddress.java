package A_OnsiteClassical.Tiktok;

import java.util.ArrayList;
import java.util.List;

public class restoreIPAddress {
  List<String> res;
  StringBuilder path;

  public List<String> restoreIpAddresses(String s) {
    if (s.length() > 12 || s.length() < 4) {
      return new ArrayList<>();
    }

    res = new ArrayList<>();
    path = new StringBuilder(s);

    dfs(path, 0, 0);
    return res;
  }

  void dfs(StringBuilder sb, int startIdx, int seg) {
    if (seg == 3) {
      if (check(sb, startIdx, sb.length() - 1)) {
        res.add(sb.toString());
      }
      return;
    }

    for (int i = startIdx; i < sb.length(); ++i) {
      if (check(sb, startIdx, i)) {
        sb.insert(i + 1, ".");
        dfs(sb, i + 2, seg + 1);
        sb.deleteCharAt(i + 1);
      } else {
        break;
      }
    }
  }

  boolean check(StringBuilder s, int i, int j) {
    if (i > j) {
      return false;
    }
    String cur = s.substring(i, j + 1);
    if (cur.length() > 1 && cur.charAt(0) == '0') {
      return false;
    }

    return Integer.parseInt(cur) <= 255;
  }
}
