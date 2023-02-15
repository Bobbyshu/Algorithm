package Leetcode.weeklycontest.NO332;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class t3 {
  public static int[][] substringXorQueries(String s, int[][] queries) {
    Map<Integer, int[]> map = new HashMap<>();
    int n = s.length();

    for (int i = 30; i > 0; --i) {
      for (int j = n - i; j >= 0; --j) {
        map.put(Integer.valueOf(s.substring(j, i + j), 2), new int[]{j, i + j - 1});
      }
    }

    int[][] res = new int[queries.length][2];
    for (int i = 0; i < queries.length; ++i) {
      res[i] = map.getOrDefault(queries[i][0] ^ queries[i][1], new int[]{-1, -1});
    }

    return res;
  }
}
