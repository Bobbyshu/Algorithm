package Leetcode.weeklycontest.Normal.NO331;

import java.util.PriorityQueue;

public class t1 {
  public long pickGifts(int[] gifts, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));
    for (int g : gifts) {
      pq.offer(g);
    }

    for (int i = 0; i < k; ++i) {
      int temp = pq.poll();
      temp = (int) Math.sqrt(temp);
      pq.offer(temp);
    }

    long res = 0L;
    while (!pq.isEmpty()) {
      res += pq.poll();
    }

    return res;
  }
}
