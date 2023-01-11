package DataStructure.Graph.Bipartite;

public class UnionFindWay {
    public boolean isBipartite(int[][] graph) {
        // 初始化并查集
        UnionFind uf = new UnionFind(graph.length);
        // 遍历每个顶点，将当前顶点的所有邻接点进行合并
        for (int i = 0; i < graph.length; i++) {
            int[] adj = graph[i];
            for (int w: adj) {
                // 若某个邻接点与当前顶点已经在一个集合中了，说明不是二分图，返回 false。
                if (uf.isConnected(i, w)) {
                    return false;
                }
                uf.union(adj[0], w);
            }
        }
        return true;
    }
}

class UnionFind {
    int[] roots;
    public UnionFind(int n) {
        roots = new int[n];
        for (int i = 0; i < n; ++i) {
            roots[i] = i;
        }
    }

    public int find(int i) {
        if (roots[i] == i) {
            return i;
        }

        return roots[i] = find(roots[i]);
    }

    public boolean isConnected(int p, int q) {
        return find(q) == find(p);
    }

    public void union(int p, int q) {
        roots[find(p)] = find(q);
    }
}
