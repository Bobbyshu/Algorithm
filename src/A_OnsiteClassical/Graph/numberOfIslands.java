package A_OnsiteClassical.Graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class numberOfIslands {
  public int numIslandsBFS(char[][] grid) {
    int m = grid.length, n = grid[0].length;
    Deque<int[]> q = new ArrayDeque<>();
    boolean[][] visited = new boolean[m][n];

    int res = 0;
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if (!visited[i][j] && grid[i][j] == '1') {
          ++res;
          bfs(grid, i, j, q, visited);
        }
      }
    }

    return res;
  }

  private void bfs(char[][] grid, int i, int j, Deque<int[]> q, boolean[][] visited) {
    q.add(new int[]{i, j});
    int[][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    while (!q.isEmpty()) {
      int[] cur = q.pollFirst();

      for (int[] dir : dirs) {
        int nextI = cur[0] + dir[0], nextJ = cur[1] + dir[1];
        if (isValid(nextI, nextJ, grid) && !visited[nextI][nextJ] && grid[nextI][nextJ] == '1') {
          q.add(new int[]{nextI, nextJ});
          visited[nextI][nextJ] = true;
        }
      }
    }

  }

  private boolean isValid(int i, int j, char[][] g) {
    return i < g.length && i >= 0 && j < g[0].length && j >= 0;
  }
}
