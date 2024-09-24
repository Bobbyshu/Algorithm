package A_OnsiteClassical.grind75;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
  public List<Integer> spiralOrder(int[][] matrix) {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    List<Integer> res = new ArrayList<>();
    int m = matrix.length, n = matrix[0].length;
    int total = m * n;
    boolean[][] visited = new boolean[m][n];
    int x = 0, y = 0, idx = 0;

    for (int i = 0; i < total; ++i) {
      res.add(matrix[x][y]);
      visited[x][y] = true;

      int newX = x + dirs[idx][0], newY = y + dirs[idx][1];
      if (newX < 0 || newY < 0 || newX >= m || newY >= n || visited[newX][newY]) {
        idx = (idx + 1) % 4;
      }
      x += dirs[idx][0];
      y += dirs[idx][1];
    }

    return res;
  }
}
