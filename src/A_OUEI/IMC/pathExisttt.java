package A_OUEI.IMC;

public class pathExisttt {
    public static void main(String[] args) {
        pathExisttt path = new pathExisttt();
        path.canReach(5, 10, 1, 14, 1);
        System.out.println(path.canReach(5, 10, 1, 14, 1));
    }
    boolean[][] visited;
    int len;
    int[][] memo;
    boolean canReach(int c, int x1, int y1, int x2, int y2) {
        this.len = Math.max(Math.max(x1, y1), Math.max(x2, y2));
        visited = new boolean[len + 1][len + 1];
//        memo = new int[len + 1][len + 1];
//        for (int[] row : memo) {
//            Arrays.fill(row, -1);
//        }
        dfs(c, x1, y1, x2, y2);
        return visited[x2][y2];
    }
    //   || x + c >= len + 1 || y + c >= len + 1
    void dfs(int c, int x, int y, int x2, int y2) {
        if (x >= len + 1 || y >= len + 1 || visited[x][y] || notAllowed(x + y))
            return;

        if (x == x2 && y == y2) {
            visited[x][y] = true;
            return;
        }

        visited[x][y] = true;
        dfs(c, x + c, y + c, x2, y2);
        dfs(c, x, x + y, x2, y2);
        dfs(c, x + y, y, x2, y2);
    }

    boolean notAllowed(int x) {
        if (x >= 0) {
            double sqrt = Math.pow((double) x, 0.5);
            return sqrt - Math.floor(sqrt) == 0;
        }
        return false;
    }
}
