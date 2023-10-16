package BISHI.GuideWire;

public class magicSquare {
  public static void main(String[] args) {
    int mat[][] = {{4, 3, 4, 5, 3},
        {2, 7, 3, 8, 4},
        {1, 7, 6, 5, 2},
        {8, 4, 9, 5, 5}};

    solution(mat);
    System.out.println(solution(mat));
    System.out.println(check(mat, 1, 1, 3));
  }

  public static int solution(int[][] arr) {
    int n = arr.length;
    int m = arr[0].length;
    int maxSize = Math.min(n, m);

    int res = 1;

    for (int size = 2; size <= maxSize; size++) {
      for (int i = 0; i <= n - size; ++i) {
        for (int j = 0; j <= m - size; ++j) {
          if (check(arr, i, j, size)) {
            res = Math.max(res, size);
          }
        }
      }
    }

    return res;
  }

  static boolean check(int[][] arr, int startI, int startJ, int size) {
    // startI = 1, startJ = 1;
    int sum1 = 0, sum2 = 0;
    int n = arr.length;
    // diagonal check
    for (int i = 0; i < size; ++i) {
      sum1 += arr[startI + i][startJ + i];
      sum2 += arr[startI + i][startJ + size - 1 - i];
    }

    if (sum1 != sum2) {
      return false;
    }

    for (int i = 0; i < size; ++i) {
      int row = 0, col = 0;
      for (int j = 0; j < size; ++j) {
        row += arr[startI + i][startJ + j];
        col += arr[startI + j][startJ + i];
      }

      if (row != col || col != sum1) {
        return false;
      }
    }

    return true;
  }
}
