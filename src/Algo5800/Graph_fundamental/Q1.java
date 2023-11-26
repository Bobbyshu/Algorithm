package Algo5800.Graph_fundamental;

import java.util.ArrayList;
import java.util.List;

public class Q1 {
  public static void main(String[] args) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < 5; ++i) {
      graph.add(new ArrayList<>());
    }
    // 1 ---- 0 ---- 3
    // |     /       |
    // |    /        |
    // |   /         |
    //  2            4
    graph.get(0).add(1);
    graph.get(0).add(2);
    graph.get(0).add(3);
    graph.get(1).add(0);
    graph.get(1).add(2);
    graph.get(2).add(0);
    graph.get(2).add(1);
    graph.get(3).add(0);
    graph.get(3).add(4);
    graph.get(4).add(3);
    checkCycle(graph);
  }

  public static boolean checkCycle(List<List<Integer>> graph) {
    int n = graph.size();
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; ++i) {
      if (!visited[i]) {
        if (dfs(i, -1, visited, graph)) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean dfs(int cur, int parent, boolean[] visited, List<List<Integer>> graph) {
    visited[cur] = true;
    for (int next : graph.get(cur)) {
      // haven't traverse
      if (!visited[next]) {
        // continue dfs
        if (dfs(next, cur, visited, graph)) {
          return true;
        }
      } else {  // traversed but we have to check whether we go back or not
        if (next != parent) { // cycle
          return true;
        }
      }
    }

    return false;
  }
}
