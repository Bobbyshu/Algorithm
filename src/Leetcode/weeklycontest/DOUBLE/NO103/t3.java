package Leetcode.weeklycontest.DOUBLE.NO103;

import java.util.LinkedList;
import java.util.Queue;

public class t3 {
  public int findMaxFish(int[][] grid) {
    int res = 0;
    int m = grid.length;
    int n = grid[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] > 0) {
          res = Math.max(res, bfs(i, j, grid));
        }
      }
    }
    return res;
  }

  public int bfs(int i, int j, int[][] grid) {
    Queue<int[]> q = new LinkedList<>();
    int n = grid.length;
    int m = grid[0].length;
    int[][] vis = new int[n][m];

    vis[i][j] = 1;
    q.add(new int[]{i, j});

    int sum = 0;
    int[] dir = {-1, 0, 1, 0, -1};
    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int x = cur[0];
      int y = cur[1];

      sum += grid[x][y];

      for (int k = 0; k < 4; k++) {
        int newX = x + dir[k];
        int newY = y + dir[k + 1];

        if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] != 0 && vis[newX][newY] == 0) {
          q.add(new int[]{newX, newY});
          vis[newX][newY] = 1;
        }
      }
    }
    return sum;
  }
}
