package Algo5800.Graph_fundamental;

import java.util.*;

import java.util.*;

class KosarajuAlgorithm {
  private int V;   // 顶点数量
  private LinkedList<Integer> adj[]; // 邻接表

  // 构造函数
  KosarajuAlgorithm(int v) {
    V = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; ++i)
      adj[i] = new LinkedList();
  }

  // 添加边到图
  void addEdge(int v, int w) {
    adj[v].add(w);
  }

  // DFS函数，用于第一次DFS和填充栈
  void fillOrder(int v, boolean visited[], Stack stack) {
    // 标记当前节点为已访问
    visited[v] = true;

    // 对所有相邻的节点进行递归调用
    for (int n : adj[v]) {
      if (!visited[n])
        fillOrder(n, visited, stack);
    }

    // 所有相邻的节点都访问后，将当前节点压入栈
    stack.push(new Integer(v));
  }

  // 获取反向图
  KosarajuAlgorithm getTranspose() {
    KosarajuAlgorithm g = new KosarajuAlgorithm(V);
    for (int v = 0; v < V; v++) {
      // 反向添加边
      for (int n : adj[v]) g.adj[n].add(v);
    }
    return g;
  }

  // 新的DFS函数，仅用于第二次DFS
  void DFSUtil(int v, boolean visited[]) {
    // 标记当前节点为已访问并打印
    visited[v] = true;
    System.out.print(v + " ");

    // 对所有相邻的节点进行递归调用
    for (int n : adj[v]) {
      if (!visited[n])
        DFSUtil(n, visited);
    }
  }

  // 打印SCCs
  void printSCCs() {
    Stack stack = new Stack();

    // 标记所有的顶点为未访问
    boolean visited[] = new boolean[V];
    Arrays.fill(visited, false);

    // 填充顺序栈
    for (int i = 0; i < V; i++) {
      if (!visited[i])
        fillOrder(i, visited, stack);
    }

    // 创建反向图
    KosarajuAlgorithm gr = getTranspose();

    // 再次标记所有顶点为未访问
    Arrays.fill(visited, false);

    // 处理所有顶点
    while (!stack.empty()) {
      // 弹出栈顶元素
      int v = (int) stack.pop();

      // 打印SCC
      if (!visited[v]) {
        gr.DFSUtil(v, visited);
        System.out.println();
      }
    }
  }

  public static void main(String args[]) {
    KosarajuAlgorithm g = new KosarajuAlgorithm(5);

    g.addEdge(1, 0);
    g.addEdge(0, 2);
    g.addEdge(2, 1);
    g.addEdge(0, 3);
    g.addEdge(3, 4);

    System.out.println("Strongly Connected Components:");
    g.printSCCs();
  }
}

