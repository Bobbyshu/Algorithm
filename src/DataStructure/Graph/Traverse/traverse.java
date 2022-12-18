package DataStructure.Graph.Traverse;

import java.util.ArrayList;
import java.util.List;

public class traverse {
    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0);
        return res;
    }

    void dfs(int[][] graph, int s) {
        if (s == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int v : graph[s]) {
            path.add(v);
            dfs(graph, v);
            path.remove(path.size() - 1);
        }
    }


}
