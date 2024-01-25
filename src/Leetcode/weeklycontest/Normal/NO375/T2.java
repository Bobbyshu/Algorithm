package Leetcode.weeklycontest.Normal.NO375;

import java.util.ArrayList;
import java.util.List;

//
//(a + b) mod m=((a mod m) + (b mod m)) mod m
//(a ⋅ b) mod m=((a mod m) ⋅ (b mod m)) mod m
//
public class T2 {
  public List<Integer> getGoodIndices(int[][] variables, int target) {
    List<Integer> res = new ArrayList<>();

    int n = variables.length;
    for (int i = 0; i < n; ++i) {
      int[] v = variables[i];
      if (quickPow(quickPow(v[0], v[1], 10), v[2], v[3]) == target) {
        res.add(i);
      }
    }

    return res;
  }

  long quickPow(long a, long b, int mod) {
    long res = 1L;
    while (b > 0) {
      // if pow is odd
      if ((b & 1) == 1) {
        res = (res % mod * a % mod) % mod;
      }
      // even can be divided
      a = (a * a) % mod;
      b >>= 1;
    }
    return res;
  }
}
