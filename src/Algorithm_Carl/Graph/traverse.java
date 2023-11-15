package Algorithm_Carl.Graph;

import java.util.ArrayList;
import java.util.List;

public class traverse {
  List<List<Integer>> res;
  List<Integer> path;

  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    path = new ArrayList<>();
    res = new ArrayList<>();
    dfs(0, graph);

    return res;
  }

  private void dfs(int i, int[][] g) {
    path.add(i);

    if (i == g.length - 1) {
      res.add(new ArrayList<>(path));
    }

    for (int next : g[i]) {
      dfs(next, g);
    }

    path.remove(path.size() - 1);
  }
}
