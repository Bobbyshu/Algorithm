package Leetcode.weeklycontest.Normal.NO339;

import java.util.*;

public class t2 {
  public List<List<Integer>> findMatrix(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int n : nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }

    int[][] arr = new int[map.size()][2];
    int idx = 0;
    for (int i : map.keySet()) {
      arr[idx][0] = i;
      arr[idx][1] = map.get(i);
      ++idx;
    }

    Arrays.sort(arr, (o1, o2) -> o2[1] - o1[1]);
    // System.out.println(Arrays.deepToString(arr));

    int max = arr[0][1];
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < max; ++i) {
      res.add(new ArrayList<>());
    }

    for (int[] a : arr) {
      for (int i = 0; i < a[1]; ++i) {
        res.get(i).add(a[0]);
      }
    }

    return res;
  }
}
