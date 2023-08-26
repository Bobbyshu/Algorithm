package Leetcode.weeklycontest.DOUBLE.NO103;

import java.util.HashSet;
import java.util.Set;

public class t2 {
  public int[] findThePrefixCommonArray(int[] A, int[] B) {
    int n = A.length;
    int[] res = new int[n];
    for (int i = 0; i < n; ++i) {
      Set<Integer> set = new HashSet<>();
      int cnt = 0;
      for (int j = 0; j <= i; ++j) {
        set.add(A[j]);
      }
      for (int j = 0; j <= i; ++j) {
        if (set.contains(B[j])) {
          ++cnt;
        }
      }
      res[i] = cnt;
    }
    return res;
  }
}
