package A_OnsiteClassical.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class topological {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < numCourses; ++i) {
      adj.add(new ArrayList<>());
    }

    int[] inDegree = new int[numCourses];
    for (int[] pre : prerequisites) {
      int cur = pre[1], next = pre[0];
      inDegree[next]++;
      adj.get(cur).add(next);
    }

    Deque<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < numCourses; ++i) {
      if (inDegree[i] == 0) {
        q.add(i);
      }
    }

    int idx = 0;

    while (!q.isEmpty()) {
      int cur = q.poll();
      ++idx;

      for (int next : adj.get(cur)) {
        --inDegree[next];
        if (inDegree[next] == 0) {
          q.add(next);
        }
      }
    }

    return idx == numCourses;
  }
}
