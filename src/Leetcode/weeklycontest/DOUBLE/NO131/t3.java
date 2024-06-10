package Leetcode.weeklycontest.DOUBLE.NO131;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class t3 {
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
