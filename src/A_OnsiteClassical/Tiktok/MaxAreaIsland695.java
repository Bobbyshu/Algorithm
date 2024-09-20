package A_OnsiteClassical.Tiktok;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxAreaIsland695 {
  public static void main(String[] args) {
    int[][] arr = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
    MaxAreaIsland695 m = new MaxAreaIsland695();
    m.maxAreaOfIsland(arr);
  }
  int[][] grid;
  int m, n;
  boolean[][] visited;
  int res;

  public int maxAreaOfIsland(int[][] grid) {
    this.grid = grid;
    this.m = grid.length;
    this.n = grid[0].length;
    this.visited = new boolean[m][n];
    this.res = 0;
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if (!visited[i][j] && grid[i][j] == 1) {
          res = Math.max(res, bfs(i, j));
        }
      }
    }

    return res;
  }

  private int bfs(int i, int j) {
    Deque<int[]> q = new ArrayDeque<>();
    int res = 0;
    q.add(new int[]{i, j});

    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    while (!q.isEmpty()) {
      ++res;
      int[] cur = q.pollFirst();


      for (int[] d : dir) {
        int newX = cur[0] + d[0], newY = cur[1] + d[1];
        if (newX < 0 || newX >= m || newY < 0 || newY >= n || visited[newX][newY] || grid[newX][newY] == 0) {
          continue;
        }
        q.add(new int[]{newX, newY});
        visited[newX][newY] = true;
      }
    }

    return res;
  }
}
