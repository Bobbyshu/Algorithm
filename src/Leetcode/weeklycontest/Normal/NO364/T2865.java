package Leetcode.weeklycontest.Normal.NO364;

import java.util.Arrays;
import java.util.List;

public class T2865 {

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 5, 2, 5, 6, 4, 6, 3, 4, 5);
    maximumSumOfHeights(list);
  }

  public static long maximumSumOfHeights(List<Integer> a) {
    int n = a.size();
    long res = 0L;
    for (int i = 0; i < n; ++i) {
      long cur = (long) a.get(i);
      long max = cur;
      for (int j = i - 1; j >= 0; --j) {
        cur = cur + (long) Math.min(max, a.get(j));
        max = (long) Math.min(max, a.get(j));
      }

      // return pivot
      max = a.get(i);

      for (int j = i + 1; j < n; ++j) {
        cur = cur + (long) Math.min(max, a.get(j));
        max = (long) Math.min(max, a.get(j));
      }

      res = Math.max(res, cur);
      // System.out.println("i= " + i);
      // System.out.println("res= " + res);
    }

    return res;
  }
}
