package BISHI.GuideWire;

import java.util.ArrayList;
import java.util.List;

public class ABstring {
  public int solution(String s) {
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < s.length(); ++i) {
      int cnt = 0;
      while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
        ++cnt;
      }
      list.add(cnt);
    }

    int max = 0;
    for (int i : list) {
      max = Math.max(max, i);
    }

    int res = 0;
    for (int i : list) {
      res += (max - i);
    }

    return res;
  }
}
