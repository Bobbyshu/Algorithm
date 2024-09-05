package A_OnsiteClassical.backtrace;

public class wordSearch79 {
  private String word;
  private boolean[][] visited;
  private char[][] board;

  public boolean exist(char[][] board, String word) {
    int m = board.length, n = board[0].length;
    this.visited = new boolean[m][n];
    this.board = board;
    this.word = word;

    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        boolean flag = backtrace(i, j, 0);
        if (flag) {
          return true;
        }
      }
    }

    return false;
  }

  private boolean backtrace(int i, int j, int curIdx) {
    if (board[i][j] != word.charAt(curIdx)) {
      return false;
    } else if (curIdx == word.length() - 1) {
      return true;
    }

    visited[i][j] = true;
    boolean res = false;
    int[][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    for (int[] d : dirs) {
      int newX = i + d[0], newY = j + d[1];
      if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && !visited[newX][newY]) {
        boolean flag = backtrace(newX, newY, curIdx + 1);
        if (flag) {
          res = true;
          break;
        }
      }
    }

    // backtrace
    visited[i][j] = false;
    return res;
  }

}
