package Leetcode.weeklycontest.Normal.NO416;

import java.util.PriorityQueue;

public class t2 {
  // 3 - 0 2- 0 2- 0 4- 0
  // 4 - 2 2 - 0 3 - 0 4 - 0  H = 8
  //
  public long minNumberOfSeconds(int h, int[] t) {
    PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1[0], o2[0]));
    for (int i : t) {
      // sumCost, curCost, primitive
      pq.offer(new long[]{ i, i, i});
    }

    long res = 0L;
    while (h > 0) {
      long[] cur = pq.poll();
      long sumCost = cur[0], curCost = cur[1], baseCost = cur[2];
      res = sumCost;
      pq.offer(new long[]{curCost + sumCost + baseCost, curCost + baseCost, baseCost});
      --h;
    }

    return res;

  }
}
