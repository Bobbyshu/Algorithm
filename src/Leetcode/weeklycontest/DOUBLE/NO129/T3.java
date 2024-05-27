package Leetcode.weeklycontest.DOUBLE.NO129;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class T3 {
  public int[] optimize(int limit, int[][] queries) {
    int[] res = new int[queries.length];
    // <idx, color>
    Map<Integer, Integer> color = new HashMap<>();
    // <color, the quantity of num with this color>
    Map<Integer, Integer> cnt = new HashMap<>();
    for (int i = 0; i < queries.length; i++) {
      int[] q = queries[i];
      int x = q[0];
      int y = q[1];
      if (color.containsKey(x)) {
        int c = color.get(x);
        if (cnt.merge(c, -1, Integer::sum) == 0) {
          cnt.remove(c);
        }
      }
      color.put(x, y);
      cnt.merge(y, 1, Integer::sum);
      res[i] = cnt.size();
    }
    return res;
  }
  public int[] queryResults(int limit, int[][] queries) {
    // <color, List<Idx>>
    Map<Integer, Set<Integer>> map = new HashMap<>();
    Map<Integer, Integer> cur = new HashMap<>();

    int n = queries.length;
    int[] res = new int[n];

    for (int i = 0; i < n; ++i) {
      int[] q = queries[i];
      int idx = q[0], color = q[1]; // 1 4
      map.putIfAbsent(color, new HashSet<>());

      if (cur.containsKey(idx) && cur.get(idx) != color) {
        int removeColor = cur.get(idx);
        map.get(removeColor).remove(idx);
        if (map.get(removeColor).isEmpty()) {
          map.remove(removeColor);
        }
      }

      map.get(color).add(idx);
      cur.put(idx, color);

      res[i] = map.size();
    }

    return res;
  }


}
