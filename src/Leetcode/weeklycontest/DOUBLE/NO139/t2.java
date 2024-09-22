package Leetcode.weeklycontest.DOUBLE.NO139;

import java.util.*;

public class t2 {
  public boolean findSafeWalk(List<List<Integer>> grid, int health) {
    health -= grid.get(0).get(0);
    if (health <= 0) {
      return false;
    }

    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
    pq.offer(new int[]{health, 0, 0});

    Map<String, Integer> map = new HashMap<>();
    map.put("0,0", health);

    int m = grid.size(), n = grid.get(0).size();
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    while (!pq.isEmpty()) {
      int[] cur = pq.poll();
      int curHealth = cur[0], i = cur[1], j = cur[2];

      if (i == m - 1 && j == n - 1) {
        return true;
      }

      for (int[] dir : dirs) {
        int x = i + dir[0], y = j + dir[1];
        if (x >= 0 && y >= 0 && x < m && y < n) {
          int newHealth = curHealth - grid.get(x).get(y);
          if (newHealth > 0) {
            String index = x + "," + y;
            if (!map.containsKey(index) || map.get(index) < newHealth) {
              map.put(index, newHealth);
              pq.offer(new int[]{newHealth, x, y});
            }
          }
        }
      }
    }

    return false;
  }
}
