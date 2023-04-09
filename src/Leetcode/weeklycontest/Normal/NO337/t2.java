package Leetcode.weeklycontest.Normal.NO337;

public class t2 {
  public static void main(String[] args) {
    int[][] arr = {{0,11,16,5,20},{17,4,19,10,15},{12,1,8,21,6},{3,18,23,14,9},{24,13,2,7,22}};
    checkValidGrid(arr);
  }
  public static boolean checkValidGrid(int[][] grid) {
    int m = grid.length;
    int step = m * m;
    int cnt = 0, curI = 0, curJ = 0;
    while (cnt < step) {
      ++cnt;
      for (int i = 0; i < m; ++i) {
        for (int j = 0; j < m; ++j) {
          if (grid[i][j] == cnt) {
            if (!check(curI, curJ, i, j)) {
              return false;
            }
            curI = i;
            curJ = j;
          }
        }
      }
    }

    return true;
  }

  static boolean check(int curI, int curJ, int i, int j) {
    double y = (double) Math.abs(curJ - j);
    double x = (double) Math.abs(curI - i);
    return y / x == 2 || y / x == 0.5;
  }
}
