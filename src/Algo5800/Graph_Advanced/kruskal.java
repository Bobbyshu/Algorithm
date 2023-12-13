package Algo5800.Graph_Advanced;

import java.util.*;

class Edge implements Comparable<Edge> {
  int src, dest, weight;

  public int compareTo(Edge compareEdge) {
    return this.weight - compareEdge.weight;
  }
}

class Subset {
  int parent, rank;
}

class GraphK {
  int vertices, edges;
  Edge[] edge;

  GraphK(int v, int e) {
    vertices = v;
    edges = e;
    edge = new Edge[e];
    for (int i = 0; i < e; ++i)
      edge[i] = new Edge();
  }

  int find(Subset subsets[], int i) {
    if (subsets[i].parent != i)
      subsets[i].parent = find(subsets, subsets[i].parent);
    return subsets[i].parent;
  }

  void Union(Subset subsets[], int x, int y) {
    int xroot = find(subsets, x);
    int yroot = find(subsets, y);

    if (subsets[xroot].rank < subsets[yroot].rank)
      subsets[xroot].parent = yroot;
    else if (subsets[xroot].rank > subsets[yroot].rank)
      subsets[yroot].parent = xroot;
    else {
      subsets[yroot].parent = xroot;
      subsets[xroot].rank++;
    }
  }

  void KruskalMST() {
    Edge result[] = new Edge[vertices];
    int e = 0;
    int i = 0;
    for (i = 0; i < vertices; ++i)
      result[i] = new Edge();

    Arrays.sort(edge);

    Subset subsets[] = new Subset[vertices];
    for (i = 0; i < vertices; ++i)
      subsets[i] = new Subset();

    for (int v = 0; v < vertices; ++v) {
      subsets[v].parent = v;
      subsets[v].rank = 0;
    }

    i = 0;
    while (e < vertices - 1) {
      Edge next_edge = new Edge();
      next_edge = edge[i++];

      int x = find(subsets, next_edge.src);
      int y = find(subsets, next_edge.dest);

      if (x != y) {
        result[e++] = next_edge;
        Union(subsets, x, y);
      }
    }

    System.out.println("Following are the edges in the constructed MST");
    for (i = 0; i < e; ++i)
      System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
  }
}

class KruskalAlgorithm {
  public static void main(String[] args) {
    int vertices = 4;
    int edges = 5;
    GraphK graphK = new GraphK(vertices, edges);

    // add edge 0-1
    graphK.edge[0].src = 0;
    graphK.edge[0].dest = 1;
    graphK.edge[0].weight = 10;

    // add edge 0-2
    graphK.edge[1].src = 0;
    graphK.edge[1].dest = 2;
    graphK.edge[1].weight = 6;

    // add edge 0-3
    graphK.edge[2].src = 0;
    graphK.edge[2].dest = 3;
    graphK.edge[2].weight = 5;

    // add edge 1-3
    graphK.edge[3].src = 1;
    graphK.edge[3].dest = 3;
    graphK.edge[3].weight = 15;

    // add edge 2-3
    graphK.edge[4].src = 2;
    graphK.edge[4].dest = 3;
    graphK.edge[4].weight = 4;

    graphK.KruskalMST();
  }
}

