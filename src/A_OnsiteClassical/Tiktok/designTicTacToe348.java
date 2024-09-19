package A_OnsiteClassical.Tiktok;

class designTicTacToe348 {
  private int[] rows;
  private int[] cols;
  private int diagonal;
  private int antiDiagonal;

  public designTicTacToe348(int n) {
    rows = new int[n];
    cols = new int[n];
  }

  public int move(int row, int col, int player) {
    int add = player == 1 ? 1 : -1;

    rows[row] += add;
    cols[col] += add;

    if (row == col) {
      diagonal += add;
    }

    int n = cols.length;
    if (col == (n - row - 1)) {
      antiDiagonal += add;
    }

    if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n
        || Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n) {
      return player;
    }

    return 0;
  }
}
