package A_OnsiteClassical.Tiktok;

import java.util.HashSet;
import java.util.Set;

public class NO694_NumberDistinctIslands {
  int[][] grid;
  int m, n;
  boolean[][] visited;

  public int numDistinctIslands(int[][] grid) {
    Set<String> set = new HashSet<>();
    this.grid = grid;
    this.m = grid.length;
    this.n = grid[0].length;
    this.visited = new boolean[m][n];

    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if (!visited[i][j] && grid[i][j] == 1) {
          StringBuilder sb = new StringBuilder();
          dfs(i, j, sb, "p");
          // System.out.println("i = " + i + " j = " + j + sb.toString());
          set.add(sb.toString());
        }
      }
    }

    // System.out.println(set);

    return set.size();
  }

  private void dfs(int i, int j, StringBuilder sb, String cur) {
    if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || grid[i][j] == 0) {
      return;
    }

    sb.append(cur);
    visited[i][j] = true;
    dfs(i + 1, j, sb, "d");
    dfs(i - 1, j, sb, "u");
    dfs(i, j + 1, sb, "r");
    dfs(i, j - 1, sb, "l");
    sb.append("b");
  }
}
