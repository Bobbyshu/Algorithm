package Algo5800.Greedy;

import java.util.Arrays;

public class problem3 {
  public static void main(String[] args) {
    int[][] arr2 = {{1, 4}, {3, 5}, {2, 6}, {7, 9}, {8, 10}};
    System.out.println(coloringIntervals(arr2));
  }
  public static int coloringIntervals(int[][] x) {
    Arrays.sort(x, (a, b) -> {
      if (a[0] != b[0]) return a[0] - b[0];
      return b[1] - a[1];
    });

    int[] lastEndOfColor = new int[x.length];
    lastEndOfColor[0] = x[0][1];

    int numColor = 1;

    for (int i = 1; i < x.length; i++) {
      int[] currInterval = x[i];
      boolean foundPrevColor = false;
      for (int j = 0; j < numColor; j++) {
        // no overlap. reuse a previous color
        if (currInterval[0] >= lastEndOfColor[j]) {
          lastEndOfColor[j] = currInterval[1];
          foundPrevColor = true;
          break;
        }
      }

      if (!foundPrevColor) {
        lastEndOfColor[numColor] = currInterval[1];
        numColor++;
      }
    }

    return numColor;
  }
}
