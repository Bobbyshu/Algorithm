package Leetcode.weeklycontest.DOUBLE.NO103;

import java.util.PriorityQueue;

public class t1 {
  public int maximizeSum(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2- o1);
    for (int n : nums) {
      pq.offer(n);
    }

    int res = 0;
    while (k > 0) {
      int cur = pq.peek();
      res += cur;
      pq.poll();
      pq.offer(cur + 1);
      --k;
    }

    return res;
  }
}
