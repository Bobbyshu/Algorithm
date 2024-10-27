package A_OnsiteClassical.Tiktok;

import java.util.ArrayDeque;
import java.util.Deque;

public class WallsAndGates286 {
  public void wallsAndGates(int[][] rooms) {
    if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
      return;
    }

    int n = rooms.length, m = rooms[0].length;
    Deque<int[]> queue = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (rooms[i][j] == 0) {
          queue.offer(new int[]{i, j});
        }
      }
    }

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // BFS
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; ++i) {
        int[] cur = queue.poll();
        int curI = cur[0], curJ = cur[1];

        for (int[] d : directions) {
          int nextI = curI + d[0], nextJ = curJ + d[1];
          if (nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < m && rooms[nextI][nextJ] == Integer.MAX_VALUE) {
            rooms[nextI][nextJ] = rooms[curI][curJ] + 1;
            queue.offer(new int[]{nextI, nextJ});
          }
        }
      }
    }

  }
}
