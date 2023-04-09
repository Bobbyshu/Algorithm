package Leetcode.weeklycontest.Normal.NO329;

import java.util.Arrays;

public class t2 {
  public static void main(String[] args) {
    int[][] res = {{10,6,9,1},{7,5,11,2},{4,8,3,15}};
    System.out.println(Arrays.deepToString(sortTheStudents(res, 2)));
  }

  public static int[][] sortTheStudents(int[][] score, int k) {
    Arrays.sort(score, (o1, o2) -> o2[k] - o1[k]);
    return score;
  }
}
