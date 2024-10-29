package A_OnsiteClassical.Tiktok;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NO305_NumberOfIslandTwo {
  // To transfer 2d array to union find
  // use int id = n * x + y
  public List<Integer> numIslands2(int m, int n, int[][] positions) {
    List<Integer> res = new ArrayList<>();
    if (m <= 0 || n <= 0) {
      return res;
    }

    int cnt = 0;
    // one island = one tree
    int[] roots = new int[m * n];
    Arrays.fill(roots, -1);

    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    for (int[] p : positions) {
      int root = n * p[0] + p[1];
      // create new island
      roots[root] = root;
      ++cnt;

      for (int[] dir : dirs) {
        int x = p[0] + dir[0], y = p[1] + dir[1];
        int curIsland = n * x + y;
        if(x < 0 || x >= m || y < 0 || y >= n || roots[curIsland] == -1) {
          continue;
        }

        int rootForCur = findIsland(roots, curIsland);
        // if neighbor is in another island
        if (root != rootForCur) {
          roots[root] = rootForCur;
          root = rootForCur;
          --cnt;
        }
      }

      res.add(cnt);
    }
    return res;
  }

  public int findIsland(int[] roots, int id) {
    while(id != roots[id]) {
      id = roots[id];
    }
    return id;
  }
}
