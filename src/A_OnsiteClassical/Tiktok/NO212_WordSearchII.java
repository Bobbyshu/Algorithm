package A_OnsiteClassical.Tiktok;

import java.util.*;
// T(n * m * 4^word[i].length)
// T(Sum(words[i].length))
public class NO212_WordSearchII {
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
