package Algorithm.BFS;
//lc773

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class SlidingPuzzle {
    int[][] neigh = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    public int slidingPuzzle(int[][] board) {
        int m = 2, n = 3;
        StringBuilder sb = new StringBuilder();
        String target = "123450";

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
        }

        String start = sb.toString();
        Deque<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.add(start);
        int step = 0;
        visited.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                assert cur != null;
                if (cur.equals(target)) {
                    return step;
                }
                int zeroPos = cur.indexOf('0');

                for (int adj : neigh[zeroPos]) {
                    String newStr = swap(cur, zeroPos, adj);
                    if (!visited.contains(newStr)) {
                        queue.add(newStr);
                        visited.add(newStr);
                    }
                }
            }
            step++;
        }

        return -1;
    }

    String swap(String str, int i, int j) {
        char[] arr = str.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }
}
