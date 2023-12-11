package Algo5800.Graph_Advanced;

import java.util.*;

public class networkDelayTime_Dijk {
  class State {
    // register the depth of node
    int id;
    int distFromStart;

    State(int distFromStart, int id) {
      this.distFromStart = distFromStart;
      this.id = id;
    }
  }

  int weight(int from, int to, int[][] times) {
    for (int[] t : times) {
      if (t[0] == from && t[1] == to) {
        return t[2];
      }
    }

    return -1;
  }

  List<List<Integer>> process(int[][] times, int n) {
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i <= n; ++i) {
      res.add(new ArrayList<>());
    }

    for (int[] t : times) {
      res.get(t[0]).add(t[1]);
    }
    return res;
  }

  public int networkDelayTime(int[][] times, int n, int k) {
    int[] disTo = new int[n + 1];
    Arrays.fill(disTo, Integer.MAX_VALUE);
    disTo[k] = 0;

    Queue<State> pq = new PriorityQueue<>((o1, o2) -> o1.distFromStart - o2.distFromStart);
    pq.offer(new State(0, k));

    List<List<Integer>> adj = process(times, n);

    while (!pq.isEmpty()) {
      State cur = pq.poll();
      int curNode = cur.id;
      int curDist = cur.distFromStart;

      if (curDist > disTo[curNode]) {
        // shorter path has been registered
        continue;
      }

      for (int nextNode : adj.get(curNode)) {
        // check whether the distance from cur to next shorter or not
        int check = weight(curNode, nextNode, times);
        if (check == -1) {
          return -1;
        }
        int disToNextNode = disTo[curNode] + check;

        if (disTo[nextNode] > disToNextNode) {
          disTo[nextNode] = disToNextNode;
          pq.offer(new State(disToNextNode, nextNode));
        }
      }
    }

    int res = -1;
    for (int i = 1; i <= n; ++i) {
      res = Math.max(res, disTo[i]);
    }

    return res == Integer.MAX_VALUE ? -1 : res;
  }

  public static void main(String[] args) {
    networkDelayTime_Dijk n = new networkDelayTime_Dijk();
    int[][] t = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
    n.networkDelayTime(t, 4, 2);
    System.out.println(n.networkDelayTime(t, 4, 2));
  }
}
