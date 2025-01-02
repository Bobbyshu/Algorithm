package A_OnsiteClassical.Graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinTimeReachLastRoom3342 {
  public static void main(String[] args) {
    int[][] arr = {{0,4},{4,4}};
    minTimeToReach(arr);
  }
  public static int minTimeToReach(int[][] moveTime) {
    int n = moveTime.length, m = moveTime[0].length;
    int[][] times = new int[n][m];

    for (int[] time : times) {
      Arrays.fill(time, Integer.MAX_VALUE);
    }

    times[0][0] = 0;
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
    pq.offer(new int[]{0, 0, 0, 1});

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    while (!pq.isEmpty()) {
      int[] cur = pq.poll();
      System.out.println(Arrays.toString(cur));
      int x = cur[0], y = cur[1], time = cur[2], curCost = cur[3];
      if (x == n - 1 && y == m - 1) {
        return time;
      }
      if (times[x][y] < time) {
        continue;
      }

      for (int[] dir : dirs) {
        int newX = x + dir[0], newY = y + dir[1];
        if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
          int nextTime = Math.max(time, moveTime[newX][newY]) + curCost;
          int alterCost = curCost == 1 ? 2 : 1;

          if (times[newX][newY] > nextTime) {
            times[newX][newY] = nextTime;
            pq.offer(new int[]{newX, newY, nextTime, alterCost});
          }
        }
      }
    }

    return times[n - 1][m - 1];
  }
}
