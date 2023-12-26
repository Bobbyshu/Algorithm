package Leetcode.weeklycontest.DOUBLE.NO117;

import java.util.*;

public class t4 {
  public long maxSpendingSort(int[][] values) {
    List<Integer> lst = new ArrayList<>();
    for (int[] v : values) {
      for (int n : v) {
        lst.add(n);
      }
    }

    Collections.sort(lst);
    long res = 0L;
    for (int i = 0; i < lst.size(); ++i) {
      res += (long) (i + 1) * (long) lst.get(i);
    }

    return res;
  }

  public long maxSpending(int[][] values) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
    for (int i = 0; i < values.length; ++i) {
      int n = values[i].length;
      pq.offer(new int[]{values[i][n - 1], i});
    }

    List<Deque<Integer>> lst = new ArrayList<>();

    int n = values.length;
    for (int i = 0; i < n; ++i) {
      lst.add(new ArrayDeque<>());
    }

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < values[i].length; ++j) {
        lst.get(i).add(values[i][j]);
      }
    }

    long day = 1L, res = 0L;
    while (day <= n * values[0].length) {
      int[] cur = pq.poll();
      // System.out.println(Arrays.toString(cur));

      int min = cur[0];
      int idx = cur[1];
      res += day * min;
      lst.get(idx).pollLast();
      if (!lst.get(idx).isEmpty()) {
        pq.offer(new int[]{lst.get(idx).peekLast(), idx});
      }
      ++day;
    }

    return res;
  }

}
