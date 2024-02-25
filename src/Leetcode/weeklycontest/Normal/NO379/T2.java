package Leetcode.weeklycontest.Normal.NO379;

public class T2 {
  public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
    int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    for (int k = 0; k < 4; k++) {
      for (int w = 1; w <= 8; w++) {
        int i = a + dir[k][0] * w;
        int j = b + dir[k][1] * w;
        if (i <= 0 || j <= 0 || i > 8 || j > 8) {
          break;
        }

        if (i == c && j == d) {
          break;
        }

        if (i == e && j == f) {
          return 1;
        }
      }
    }

    for (int k = 4; k < 8; k++) {
      for (int w = 1; w <= 8; w++) {
        int i = c + dir[k][0] * w, j = d + dir[k][1] * w;
        if (i <= 0 || j <= 0 || i > 8 || j > 8) {
          break;
        }
        if (i == a && j == b) {
          break;
        }
        if (i == e && j == f) {
          return 1;
        }
      }
    }

    return 2;
  }
}
