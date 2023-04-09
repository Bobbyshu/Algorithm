package Leetcode.weeklycontest.DOUBLE.NO100;

import java.util.PriorityQueue;

public class t3 {
  public long findScore(int[] nums) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ?
        o1[1] - o2[1] : o1[0] - o2[0]);
    for (int i = 0; i < nums.length; ++i) {
      pq.offer(new int[]{nums[i], i});
    }

    // while (!pq.isEmpty()) {
    //     int[] res = pq.poll();
    //     System.out.println(Arrays.toString(res));
    // }

    boolean[] vis = new boolean[nums.length];
    long res = 0;

    while (!pq.isEmpty()) {
      int val = pq.peek()[0];
      int idx = pq.peek()[1];
      pq.poll();

      if (!vis[idx]) {
        res += val;
        vis[idx] = true;
        if (idx >= 1) {
          vis[idx - 1] = true;
        }

        if (idx < nums.length - 1) {
          vis[idx + 1] = true;
        }
      }
    }

    return res;
  }
}
