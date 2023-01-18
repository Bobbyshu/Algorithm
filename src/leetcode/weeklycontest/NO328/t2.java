package leetcode.weeklycontest.NO328;

import java.util.Arrays;

public class t2 {
  public static void main(String[] args) {
    int[][] arr = {{1,1,2,2},{0,0,1,1}};
    System.out.println(Arrays.deepToString(rangeAddQueries(3, arr)));
  }
  public static int[][] rangeAddQueries(int n, int[][] queries) {
    int[][] res = new int[n][n];
    for (int[] q : queries) {
      for (int i = q[0]; i <= q[2]; ++i) {
        for (int j = q[1]; j <= q[3]; ++j) {
          ++res[i][j];
        }
      }
    }
    return res;
  }
}
