package Leetcode.weeklycontest.DOUBLE.NO101;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class t3 {
  public long makeSubKSumEqual(int[] arr, int k) {
    int n = arr.length;
    if (n == k) {
      return 0;
    }

    long res = 0L;
    int common = gcd(n, k);
    for (int i = 0; i < common; ++i) {
      List<Integer> list = new ArrayList<>();
      for (int j = i; j < n; j += common) {
        list.add(arr[j]);
      }
      res += cal(list);
    }
    return res;
  }

  int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  long cal(List<Integer> list) {
    Collections.sort(list);
    int mid = list.get(list.size() / 2);
    long res = 0L;
    for (int l : list) {
      res += Math.abs(l - mid);
    }
    return res;
  }
}
