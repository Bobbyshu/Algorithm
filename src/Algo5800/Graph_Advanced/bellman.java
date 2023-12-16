package Algo5800.Graph_Advanced;// A Java program for Bellman-Ford's single source shortest
// path algorithm.

import java.lang.*;

// A class to represent a connected, directed and weighted
// graph
class bellman {

  // A class to represent a weighted edge in graph
  class Edge {
    int src, dest, weight;
    Edge() { src = dest = weight = 0; }
  };

  int V, E;
  Edge edge[];

  // Creates a graph with V vertices and E edges
  bellman(int v, int e)
  {
    V = v;
    E = e;
    edge = new Edge[e];
    for (int i = 0; i < e; ++i)
      edge[i] = new Edge();
  }

  // The main function that finds shortest distances from
  // src to all other vertices using Bellman-Ford
  // algorithm. The function also detects negative weight
  // cycle
  void BellmanFord(bellman bellman, int src)
  {
    int V = bellman.V, E = bellman.E;
    int dist[] = new int[V];

    // Step 1: Initialize distances from src to all
    // other vertices as INFINITE
    for (int i = 0; i < V; ++i)
      dist[i] = Integer.MAX_VALUE;
    dist[src] = 0;

    // Step 2: Relax all edges |V| - 1 times. A simple
    // shortest path from src to any other vertex can
    // have at-most |V| - 1 edges
    for (int i = 1; i < V; ++i) {
      for (int j = 0; j < E; ++j) {
        int u = bellman.edge[j].src;
        int v = bellman.edge[j].dest;
        int weight = bellman.edge[j].weight;
        if (dist[u] != Integer.MAX_VALUE
            && dist[u] + weight < dist[v])
          dist[v] = dist[u] + weight;
      }
    }

    // Step 3: check for negative-weight cycles. The
    // above step guarantees shortest distances if graph
    // doesn't contain negative weight cycle. If we get
    // a shorter path, then there is a cycle.
    for (int j = 0; j < E; ++j) {
      int u = bellman.edge[j].src;
      int v = bellman.edge[j].dest;
      int weight = bellman.edge[j].weight;
      if (dist[u] != Integer.MAX_VALUE
          && dist[u] + weight < dist[v]) {
        System.out.println(
            "Graph contains negative weight cycle");
        return;
      }
    }
    printArr(dist, V);
  }

  // A utility function used to print the solution
  void printArr(int dist[], int V)
  {
    System.out.println("Vertex Distance from Source");
    for (int i = 0; i < V; ++i)
      System.out.println(i + "\t\t" + dist[i]);
  }

  // Driver's code
  public static void main(String[] args)
  {
    int V = 5; // Number of vertices in graph
    int E = 8; // Number of edges in graph

    bellman bellman = new bellman(V, E);

    // add edge 0-1 (or A-B in above figure)
    bellman.edge[0].src = 0;
    bellman.edge[0].dest = 1;
    bellman.edge[0].weight = -1;

    // add edge 0-2 (or A-C in above figure)
    bellman.edge[1].src = 0;
    bellman.edge[1].dest = 2;
    bellman.edge[1].weight = 4;

    // add edge 1-2 (or B-C in above figure)
    bellman.edge[2].src = 1;
    bellman.edge[2].dest = 2;
    bellman.edge[2].weight = 3;

    // add edge 1-3 (or B-D in above figure)
    bellman.edge[3].src = 1;
    bellman.edge[3].dest = 3;
    bellman.edge[3].weight = 2;

    // add edge 1-4 (or B-E in above figure)
    bellman.edge[4].src = 1;
    bellman.edge[4].dest = 4;
    bellman.edge[4].weight = 2;

    // add edge 3-2 (or D-C in above figure)
    bellman.edge[5].src = 3;
    bellman.edge[5].dest = 2;
    bellman.edge[5].weight = 5;

    // add edge 3-1 (or D-B in above figure)
    bellman.edge[6].src = 3;
    bellman.edge[6].dest = 1;
    bellman.edge[6].weight = 1;

    // add edge 4-3 (or E-D in above figure)
    bellman.edge[7].src = 4;
    bellman.edge[7].dest = 3;
    bellman.edge[7].weight = -3;

    // Function call
    bellman.BellmanFord(bellman, 0);
  }
}
// Contributed by Aakash Hasija