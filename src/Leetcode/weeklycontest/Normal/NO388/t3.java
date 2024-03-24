package Leetcode.weeklycontest.Normal.NO388;

import java.util.*;

public class t3 {
  public String[] shortestSubstrings(String[] arr) {
    Map<String, Integer> map = new HashMap<>();
    for (String s : arr) {
      for (int i = 0; i < s.length(); ++i) {
        for (int j = i + 1; j <= s.length(); ++j) {
          String cur = s.substring(i, j);
          map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
      }
    }

    int n = arr.length;
    String[] res = new String[n];
    Arrays.fill(res, "");
    for (int i = 0; i < n; ++i) {
      Map<String, Integer> curStr = new HashMap<>();
      String cur = arr[i];
      List<String> curSub = new ArrayList<>();
      for (int j = 0; j < cur.length(); ++j) {
        for (int k = j + 1; k <= cur.length(); ++k) {
          String sub = cur.substring(j, k);
          curSub.add(sub);
          curStr.put(sub, curStr.getOrDefault(sub, 0) + 1);
        }
      }

      curSub.sort((s1, s2) -> {
        // 首先按照长度升序排序
        int lengthCompare = Integer.compare(s1.length(), s2.length());
        if (lengthCompare != 0) {
          return lengthCompare;
        }
        // 如果长度相同，按照字典序排序
        return s1.compareTo(s2);
      });

      for (String s : curSub) {
        if (curStr.get(s) == map.get(s)) {
          res[i] = s;
          break;
        }
      }
    }

    return res;
  }
}
