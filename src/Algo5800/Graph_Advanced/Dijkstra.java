package Algo5800.Graph_Advanced;

import java.util.*;

// time complexity: O(ElogV)
public class Dijkstra {
  class State {
    // register the depth of node
    int id;
    int distFromStart;

    State(int distFromStart, int id) {
      this.distFromStart = distFromStart;
      this.id = id;
    }
  }

  int weight(int from, int to) {
    return 0;
  }
  List<Integer> adj(int s) {
    return new ArrayList<>();
  }

  int[] dijkstra(int start, List<Integer>[] graph) {
    int v = graph.length;
    int[] disTo = new int[v];
    Arrays.fill(disTo, Integer.MAX_VALUE);
    disTo[start] = 0;

    Queue<State> pq = new PriorityQueue<>((o1, o2) -> o1.distFromStart - o2.distFromStart);
    pq.offer(new State(start, 0));

    while (!pq.isEmpty()) {
      State cur = pq.poll();
      int curNode = cur.id;
      int curDist = cur.distFromStart;

      // if we have end node, we don't need to check other
//      if (curNode == end) {
//        return curDist;
//      }

      if (curDist > disTo[curNode]) {
        // shorter path has been registered
        continue;
      }

      for (int nextNode : adj(curNode)) {
        // check whether the distance from cur to next shorter or not
        int disToNextNode = disTo[curNode] + weight(curNode, nextNode);
        if (disTo[nextNode] > disToNextNode) {
          disTo[nextNode] = disToNextNode;
          pq.offer(new State(nextNode, disToNextNode));
        }
      }
    }
    return disTo;
  }
}
