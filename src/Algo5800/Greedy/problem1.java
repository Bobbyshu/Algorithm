package Algo5800.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class problem1 {
  public static void main(String[] args) {
    int[][] arr = {
        {1, 6},
        {1, 3},
        {3, 5},
        {13, 15},
        {2, 10},
        {3, 7},
        {8, 9},
        {4, 6},
        {9, 11},
        {12, 14},
        {12, 15},
        {12, 16},
        {20, 30}
    };
    int[][] arr2 = {{1, 4}, {3, 5}, {2, 6}, {7, 9}, {8, 10}};
    smallestCover(arr2);
//    solve2(arr2);
  }

  public static void smallestCover(int[][] x) {
    Arrays.sort(x, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
    System.out.println(Arrays.deepToString(x));

    List<int[]> res = new ArrayList<>();

    res.add(x[0]);
    int[] last = x[0];

    for (int i = 1; i < x.length; ++i) {
      int[] cur = x[i];
      if (cur[0] <= last[1]) {
        // extend f_i
        if (last[1] < cur[1]) {
          last = cur;
        }

      } else {
        // update new interval and last longest f_i interval
        res.add(last);
        res.add(cur);
        last = cur;
      }
    }
    res.add(last);

    for (int[] s : res) {
      System.out.println(Arrays.toString(s));
    }
  }

  public static void solve2(int[][] x) {
    Arrays.sort(x, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
    System.out.println(Arrays.deepToString(x));

    List<int[]> result = new ArrayList<>();
    int right = x[0][1];
    int maxRight = x[0][1];
    int[] maxInterval = x[0];

    for (int[] interval : x) {
      if (interval[0] < right) {
        if (interval[1] > maxRight) {
          maxRight = interval[1];
          maxInterval = interval;
        }
      } else {
        result.add(maxInterval);
        right = maxRight;
        maxRight = interval[1];
        maxInterval = interval;
      }
    }

    result.add(maxInterval);

    // Print the result
    for (int[] interval : result) {
      System.out.println(Arrays.toString(interval));
    }
  }
}
