package Leetcode.weeklycontest.DOUBLE.NO100;

import java.util.Arrays;

public class t4 {
  public long repairCars(int[] ranks, int cars) {
    long min = Long.MAX_VALUE;
    for (int r : ranks) {
      min = Math.min(min, r);
    }

    long l = 1L;
    long r = min * cars * cars;

    while (l < r) {
      long mid = (l + r) >> 1;
      long sum = 0L;
      // t = r * n^2
      // n = (t / r) ^ (1 / 2)
      for (int n : ranks) {
        sum += Math.sqrt(mid / n);
      }
      if (sum >= cars) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }

    return r;
  }
}
