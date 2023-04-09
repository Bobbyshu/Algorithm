package BISHI.Cisco.ngAndIntern;

import java.util.*;

public class wordSearch {
    Set<String> set = new HashSet<>();
    char[][] board;
    boolean[][] vis = new boolean[15][15];
    int m, n;
    List<String> res = new ArrayList<>();
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    Map<Character, Integer> map;

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        m = board.length;
        n = board[0].length;
        map = new HashMap<>();
        for (String w : words) {
            set.add(w);
            for (char c : w.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = true;
                sb.append(board[i][j]);
                backtrace(i, j, sb);
                sb.deleteCharAt(sb.length() - 1);
                vis[i][j] = false;
            }
        }

        return res;
    }

    void backtrace(int i, int j, StringBuilder sb) {
//         Map<Character, Integer> check = new HashMap<>();
//         for (char c : sb.toString().toCharArray()) {
//             check.put(c, check.getOrDefault(c, 0) + 1);
//         }
//         for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//             char c = entry.getKey();
//             int time = entry.getValue();
//             if (time > map.get(c))
//                 return;
//         }
        if (sb.length() > 10 || !map.containsKey(board[i][j]))
            return;

        if (set.contains(sb.toString())) {
            res.add(sb.toString());
            set.remove(sb.toString());
        }

        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && y >= 0 && x < m && y < n && !vis[x][y]) {
                vis[x][y] = true;
                sb.append(board[x][y]);
                backtrace(x, y, sb);
                sb.deleteCharAt(sb.length() - 1);
                vis[x][y] = false;
            }
        }
    }
}
