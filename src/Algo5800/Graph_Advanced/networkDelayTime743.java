package Algo5800.Graph_Advanced;

import java.util.*;

public class networkDelayTime743 {
  public int networkDelayTime(int[][] times, int n, int k) {
    List<List<int[]>> adj = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      adj.add(new ArrayList<>());
    }

    for (int[] t : times) {
      adj.get(t[0] - 1).add(new int[]{t[1] - 1, t[2]});
    }

    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE / 2);
    dist[k - 1] = 0;

    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
    pq.offer(new int[]{0, k - 1});

    while (!pq.isEmpty()) {
      int[] cur = pq.poll();
      int time = cur[0], i = cur[1];

      // 此处不能留等于，因为算法是从当前队列取出距离最小的节点，
      // 如果当前距离相同，但是存在其他的最优未来
      // 如果当前从队列中取出的距离 y 比记录的最短距离 dist[x] 还大，说明
      // 当前节点 x 是通过一条次优路径进入队列的，因为优先队列可能包含多次更新的同一个节点
      // 这样才会舍弃
      if (dist[i] < time) {
        continue;
      }

      for (int[] next : adj.get(i)) {
        int j = next[0], d = dist[i] + next[1];
        if (d < dist[j]) {
          dist[j] = d;
          pq.offer(new int[]{d, j});
        }
      }
    }

    int res = 0;
    for (int d : dist) {
      res = Math.max(res, d);
    }

    return res == Integer.MAX_VALUE / 2 ? -1 : res;
  }
}
