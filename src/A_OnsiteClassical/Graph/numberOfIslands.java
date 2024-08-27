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
      // we can't mark cur[0] and cur[1] at here
      // cuz we need to let every node only traverse once
      //       1 1 1
      // image 1 1 1 for the middle 1, it will come in queue more than once
      //       1 1 1
      // at the same level traverse, some node may be added into queue
      // more than once
      // visited[nextI][nextJ] = true;
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
