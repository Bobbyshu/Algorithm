package Leetcode.weeklycontest.DOUBLE.NO102;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class t4 {
  List<int[]>[] adj;
  int n;

  public t4(int n, int[][] edges) {
    this.n = n;
    adj = new List[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<>();
    }
    for (int[] edge : edges) {
      int from = edge[0], to = edge[1], cost = edge[2];
      adj[from].add(new int[]{to, cost});
    }
  }

  public void addEdge(int[] edge) {
    int from = edge[0], to = edge[1], cost = edge[2];
    adj[from].add(new int[]{to, cost});
  }

  public int shortestPath(int node1, int node2) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[node1] = 0;
    pq.offer(new int[]{node1, 0});
    while (!pq.isEmpty()) {
      int[] cur = pq.poll();
      int node = cur[0], distance = cur[1];
      if (node == node2) {
        return distance;
      }
      if (distance > dist[node]) {
        continue;
      }
      for (int[] neighbor : adj[node]) {
        int nextNode = neighbor[0], edgeCost = neighbor[1];
        int newDist = distance + edgeCost;
        if (newDist < dist[nextNode]) {
          dist[nextNode] = newDist;
          pq.offer(new int[]{nextNode, newDist});
        }
      }
    }
    return -1;
  }
}