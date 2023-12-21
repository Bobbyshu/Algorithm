package Algorithm_Carl.Graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class floodFill {
  int pre;
  int m, n;
  boolean[][] visited;

  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    m = image.length;
    n = image[0].length;
    pre = image[sr][sc];
    visited = new boolean[m][n];
    dfs(image, sr, sc, color);
    return image;
  }

  private void dfs(int[][] image, int sr, int sc, int color) {
    if (sr < 0 || sr >= m || sc < 0 || sc >= n || image[sr][sc] != pre || visited[sr][sc]) {
      return;
    }

    image[sr][sc] = color;
    visited[sr][sc] = true;
    dfs(image, sr + 1, sc, color);
    dfs(image, sr - 1, sc, color);
    dfs(image, sr, sc + 1, color);
    dfs(image, sr, sc - 1, color);
  }

  public int[][] bfs(int[][] image, int sr, int sc, int color) {
    Deque<int[]> q = new ArrayDeque<>();

    q.add(new int[]{sr, sc});
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int pre = image[sr][sc];
    boolean[][] visited = new boolean[m][n];
    // visited[sr][sc] = true;

    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; ++i) {
        int[] cur = q.poll();
        image[cur[0]][cur[1]] = color;
        visited[cur[0]][cur[1]] = true;
        for (int[] d : dirs) {
          int x = cur[0] + d[0], y = cur[1] + d[1];
          if (x < 0 || x >= m || y < 0 || y >= n || image[x][y] != pre || visited[x][y]) {
            continue;
          }
          q.add(new int[]{x, y});
        }
      }

    }

    return image;
  }
}
