package DataStructure.Graph.Traverse;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FindExistedPath {
    public boolean validPathInDFS(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            adj[x].add(y);
            adj[y].add(x);
        }

        boolean[] visited = new boolean[n];
        return dfs(source, destination, adj, visited);
    }

    boolean dfs(int s, int d, List<Integer>[] adj, boolean[] visited) {
        if (s == d) {
            return true;
        }

        visited[s] = true;
        for (int next : adj[s]) {
            if (!visited[next] && dfs(next, d, adj, visited)) {
                return true;
            }
        }

        return false;
    }

    public boolean validPathInBFS(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            adj[x].add(y);
            adj[y].add(x);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(source);
        boolean[] visited = new boolean[n];
        visited[source] = true;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            if (vertex == destination) {
                return true;
                // break;
            }
            for (int next : adj[vertex]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }

        return visited[destination];
    }


}
