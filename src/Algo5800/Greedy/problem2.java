package Algo5800.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class problem2 {
  public static void main(String[] args) {
    int[][] arr2 = {{1, 4}, {3, 5}, {2, 6}, {7, 9}, {8, 10}};
    System.out.println(findMinArrowShots(arr2));
  }
  public static int findMinArrowShots(int[][] points) {
    Arrays.sort(points, new Comparator<int[]>() {
      public int compare(int[] p1, int[] p2) {
        if (p1[1] > p2[1]) {
          return 1;
        } else if (p1[1] < p2[1]) {
          return -1;
        } else {
          return 0;
        }
      }
    });
    // System.out.println(Arrays.deepToString(points));
    long last = Long.MIN_VALUE;

    int cnt = 0;
    for (int[] p : points) {
      if (p[0] > last) {
        ++cnt;
        last = p[1];
      }
    }

    return cnt;
  }
}
