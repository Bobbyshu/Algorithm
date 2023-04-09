package Leetcode.weeklycontest.DOUBLE.NO101;

import java.util.*;

public class t4 {
  List<Integer>[] gr;

  void addEdge(int x, int y) {
    gr[x].add(y);
    gr[y].add(x);
  }

  int shortestCycle(int n) {
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      List<Integer> dist = new ArrayList<>(Collections.nCopies(n, (int)1e9));
      List<Integer> par = new ArrayList<>(Collections.nCopies(n, -1));
      dist.set(i, 0);
      Queue<Integer> queue = new LinkedList<>();
      queue.offer(i);
      while (!queue.isEmpty()) {
        int x = queue.poll();
        for (int child : gr[x]) {
          if (dist.get(child) == (int)1e9) {
            dist.set(child, dist.get(x) + 1);
            par.set(child, x);
            queue.offer(child);
          } else if (par.get(x) != child && par.get(child) != x) {
            ans = Math.min(ans, dist.get(x) + dist.get(child) + 1);
          }
        }
      }
    }
    if (ans == Integer.MAX_VALUE)
      return -1;
    else
      return ans;
  }
  public int findShortestCycle(int n, int[][] edges) {
    gr = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      gr[i] = new ArrayList<>();
    }
    for (int[] edge : edges) {
      addEdge(edge[0], edge[1]);
    }
    int ans = shortestCycle(n);
    return ans;
  }
}
