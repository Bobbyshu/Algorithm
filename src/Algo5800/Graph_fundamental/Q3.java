package Algo5800.Graph_fundamental;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
// Output: [0,2,1,3]
// Explanation: There are a total of 4 courses to take.
// To take course 3 you should have finished both courses 1 and 2.
// Both courses 1 and 2 should be taken after you finished course 0.
// So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
public class Q3 {
  public static void main(String[] args) {
    int[][] pre = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
    bfs(4, pre);
  }

  public static int[] bfs(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adj = new ArrayList<>();
    int[] inDegree = new int[numCourses];
    for (int i = 0; i < numCourses; ++i) {
      adj.add(new ArrayList<>());
    }

    for (int[] pre : prerequisites) {
      int from = pre[1], to = pre[0];
      inDegree[to]++;
      adj.get(from).add(to);
    }

    System.out.println(adj);

    Deque<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < numCourses; ++i) {
      if (inDegree[i] == 0) {
        q.add(i);
      }
    }

    int[] res = new int[numCourses];
    int idx = 0;

    while (!q.isEmpty()) {
      int cur = q.poll();
      res[idx++] = cur;

      for (int next : adj.get(cur)) {
        inDegree[next]--;
        if (inDegree[next] == 0) {
          q.add(next);
        }
      }
    }

    return idx == numCourses ? res : new int[0];
  }
}
