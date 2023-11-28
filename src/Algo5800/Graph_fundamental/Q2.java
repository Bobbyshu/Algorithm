package Algo5800.Graph_fundamental;

import java.util.*;

public class Q2 {
  static class Node {
    int vertex;
    int modK;
    Node parent;

    Node(int vertex, int modK, Node parent) {
      this.vertex = vertex;
      this.modK = modK;
      this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Node node = (Node) o;
      return vertex == node.vertex && modK == node.modK;
    }

    @Override
    public int hashCode() {
      return Objects.hash(vertex, modK);
    }
  }

  public static List<Integer> findPath(int n, Map<Integer, List<Integer>> adj, int s, int t, int k) {
    boolean[][] visited = new boolean[n][k];
    Deque<Node> q = new ArrayDeque<>();

    Node startNode = new Node(s, 0, null);
    // start BFS
    visited[s][0] = true;
    q.offer(startNode);

    while (!q.isEmpty()) {
      Node cur = q.poll();

      if (cur.vertex == t && cur.modK == 0) {
        return constructPath(cur);
      }

      for (int neighbor : adj.getOrDefault(cur.vertex, Collections.emptyList())) {
        int nextModK = (cur.modK + 1) % k;
        if (!visited[neighbor][nextModK]) {
          visited[neighbor][nextModK] = true;
          Node nextNode = new Node(neighbor, nextModK, cur);
          q.offer(nextNode);
        }
      }
    }

    return new ArrayList<>();
  }

  private static List<Integer> constructPath(Node targetNode) {
    List<Integer> path = new ArrayList<>();
    Node current = targetNode;
    while (current != null) {
      path.add(current.vertex);
      current = current.parent;
    }

    Collections.reverse(path);
    return path;
  }

  public static void main(String[] args) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < 8; ++i) {
      map.putIfAbsent(i, new ArrayList<>());
    }
    // A B C D E F G H
    int[][] arr = {{1}, {2, 4, 5}, {3, 6}, {2, 7}, {0, 5}, {6}, {5}, {6}};
    for (int i = 0; i < arr.length; ++i) {
      for (int num : arr[i]) {
        map.get(i).add(num);
      }
    }

//    System.out.println(map);
    // A B F
    System.out.println(findPath(8, map, 0, 5, 2));
    //
    System.out.println(findPath(8, map, 0, 5, 15));
  }
}