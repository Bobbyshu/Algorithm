package A_OnsiteClassical.Graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class rottenOrange {
  int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
  // boolean[][] visited;
  int m,n;
  public int orangesRotting(int[][] grid) {
    this.m = grid.length;
    this.n = grid[0].length;
    // visited = new boolean[m][n];

    Deque<int[]> q = new ArrayDeque<>();
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if (grid[i][j] == 2) {
          q.add(new int[]{i, j});
          // visited[i][j] = true;
        }
      }
    }

    int time = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; ++i) {
        int[] cur = q.pollFirst();
        for (int[] d : dir) {
          int nextI = cur[0] + d[0], nextJ = cur[1] + d[1];
          if (check(nextI, nextJ) && grid[nextI][nextJ] == 1) {
            grid[nextI][nextJ] = 2;
            q.add(new int[]{nextI, nextJ});
          }
        }
      }
      ++time;
    }

    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if (grid[i][j] == 1) {
          return -1;
        }
      }
    }

    return Math.max(time - 1, 0);
  }

  private boolean check(int i, int j) {
    return i < m && i >= 0 && j < n && j >= 0;
  }
}
