package Leetcode.weeklycontest.NO333;

import java.util.*;

public class t1 {
  public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
    List<int[]> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int[] n : nums1) {
      map.put(n[0], map.getOrDefault(n[0], 0) + n[1]);
    }

    for (int[] n : nums2) {
      map.put(n[0], map.getOrDefault(n[0], 0) + n[1]);
    }

    for (int v : map.keySet()) {
      list.add(new int[]{v, map.get(v)});
    }

    int[][] res = new int[list.size()][2];
    for (int i = 0; i < list.size(); ++i) {
      res[i] = list.get(i);
    }

    Arrays.sort(res, (o1, o2) -> o1[0] - o2[0]);
    return res;
  }
}
