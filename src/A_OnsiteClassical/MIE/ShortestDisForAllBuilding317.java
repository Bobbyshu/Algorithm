package A_OnsiteClassical.MIE;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestDisForAllBuilding317 {

  public int shortestDistance(int[][] grid) {
    int n = grid.length, m = grid[0].length;
    Deque<int[]> q = new ArrayDeque<>();
    int[][] reach = new int[n][m];
    int[][] distance = new int[n][m];
    int building = 0;

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        if (grid[i][j] == 1) {
          bfs(q, grid, reach, distance, i, j);
          ++building;
        }
      }
    }

    int res = Integer.MAX_VALUE;

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        if (reach[i][j] == building) {
          res = Math.min(res, distance[i][j]);
        }
      }
    }

    return res == Integer.MAX_VALUE ? -1 : res;
  }

  private void bfs(Deque<int[]> q, int[][] grid, int[][] reach, int[][] dis, int i, int j) {
    boolean[][] visited = new boolean[dis.length][dis[0].length];
    q.add(new int[]{i, j});
    visited[i][j] = true;

    int step = 1;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    while (!q.isEmpty()) {
      int size = q.size();
      for (int k = 0; k < size; ++k) {
        int[] cur = q.pollFirst();

        for (int[] dir : dirs) {
          int nextI = cur[0] + dir[0], nextJ = cur[1] + dir[1];
          if (nextI >= 0 && nextI < dis.length && nextJ >= 0 && nextJ < dis[0].length
              && !visited[nextI][nextJ] && grid[nextI][nextJ] == 0) {
            dis[nextI][nextJ] += step;
            reach[nextI][nextJ]++;

            visited[nextI][nextJ] = true;
            q.add(new int[]{nextI, nextJ});
          }
        }
      }
      ++step;
    }
  }

}
