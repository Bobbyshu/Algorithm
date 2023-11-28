package Algo5800.Graph_fundamental;

import java.util.ArrayList;
import java.util.List;


public class Graph {
  private int V; // Number of vertices
  private List<List<Integer>> adj; // Adjacency List

  // Constructor
  public Graph(int V) {
    this.V = V;
    adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }
  }

  // Function to add an edge into the graph
  void addEdge(int v, int w) {
    adj.get(v).add(w);
    adj.get(w).add(v); // Since the graph is undirected
  }

  List<Integer> path;
  List<Integer> res;
  // DFS function to find the minimal cycle
  private void dfs(int i, boolean[] visited, int[] parent) {
    visited[i] = true;
    path.add(i);

    for (int v : adj.get(i)) {
      if (!visited[v]) {
        parent[v] = i;
        dfs(v, visited, parent);
      } else if (v != parent[i] && path.contains(v)) {
        List<Integer> cycle = new ArrayList<>();
        for (int idx = path.indexOf(v); idx < path.size(); idx++) {
          cycle.add(path.get(idx));
        }

        if (res.isEmpty() || cycle.size() < res.size()) {
          res.clear();
          res.addAll(cycle);
        }
      }
    }

    path.remove(path.size() - 1);
  }

  // Function to find the minimal cycle
  public List<Integer> findMinimalCycle() {
    boolean[] visited = new boolean[V];
    int[] parent = new int[V];
    path = new ArrayList<>();
    res = new ArrayList<>();

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        dfs(i, visited, parent);
      }
    }

    return res.isEmpty() ? null : res;
  }

  public static void main(String[] args) {
    // Example usage
    Graph g = new Graph(6);
    g.addEdge(0, 1);
    g.addEdge(0, 5);
    g.addEdge(2, 1);
    g.addEdge(2, 3);
    g.addEdge(2, 4);
    g.addEdge(3, 4);
    g.addEdge(4, 5);

    List<Integer> minCycle = g.findMinimalCycle();
    if (minCycle != null) {
      System.out.println("Minimal cycle found: " + minCycle);
    } else {
      System.out.println("No minimal cycle found");
    }
  }
}

