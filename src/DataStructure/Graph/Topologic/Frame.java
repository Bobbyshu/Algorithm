package DataStructure.Graph.Topologic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Frame {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            adj.add(new ArrayList<>());
        }

        for (int[] index : prerequisites) {
            int from = index[1];
            int to = index[0];
            ++inDegree[to];
            adj.get(from).add(to);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; ++i) {
            if (inDegree[i] == 0)
                queue.add(i);
        }

        int index = 0;
        int[] res = new int[numCourses];

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res[index] = cur;
            ++index;

            for (int next : adj.get(cur)) {
                --inDegree[next];
                if (inDegree[next] == 0)
                    queue.add(next);
            }
        }

        return index == numCourses ? res : new int[0];
    }
}
