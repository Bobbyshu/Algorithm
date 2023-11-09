package Algo5800.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class problem3 {
  public static void main(String[] args) {
    int[][] arr2 = {{1, 4}, {3, 5}, {2, 6}, {7, 9}, {8, 10}};
    System.out.println(coloringIntervals(arr2));
  }
  public static int coloringIntervals(int[][] x) {
    Arrays.sort(x, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

//    int[] lastEndOfColor = new int[x.length];
    List<Integer> lastEndOfColor = new ArrayList<>();
//    lastEndOfColor[0] = x[0][1];
    lastEndOfColor.add(x[0][1]);
//    int numColor = 1;

    for (int i = 1; i < x.length; i++) {
      int[] currInterval = x[i];
      boolean foundPrevColor = false;
      for (int j = 0; j < lastEndOfColor.size(); j++) {
        // no overlap. reuse a previous color
        if (currInterval[0] >= lastEndOfColor.get(j)) {
//          lastEndOfColor[j] = currInterval[1];
          lastEndOfColor.set(j, currInterval[1]);
          foundPrevColor = true;
          break;
        }
      }

      if (!foundPrevColor) {
//        lastEndOfColor[numColor] = currInterval[1];
//        numColor++;
        lastEndOfColor.add(currInterval[1]);
      }
    }

    return lastEndOfColor.size();
  }
}
