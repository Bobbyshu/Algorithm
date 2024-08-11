package Leetcode.weeklycontest.Normal.NO410;

import java.util.ArrayList;
import java.util.List;

public class T2 {
  int res = 0;
  public int countGoodNodes(int[][] edges) {
    int node = edges.length + 1;
    List<List<Integer>> adj = new ArrayList<>();

    for (int i = 0; i < node; ++i) {
      adj.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
      int u = edge[0], v = edge[1];
      adj.get(u).add(v);
      adj.get(v).add(u);
    }

    dfs(0, -1, adj);

    return res;
  }

  private int dfs(int u, int parent, List<List<Integer>> adj) {
    int cntSum = 1;
    int singleCnt = 0;
    boolean valid = true;

    for (int v : adj.get(u)) {
      if (v == parent) {
        continue;
      }

      int cnt = dfs(v, u, adj);
      cntSum += cnt;
      if (singleCnt == 0) {
        singleCnt = cnt;
      } else if (singleCnt != cnt) {
        valid = false;
      }
    }

    if (valid) {
      ++res;
    }

    return cntSum;
  }
}
