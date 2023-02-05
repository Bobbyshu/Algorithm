package Leetcode.weeklycontest.NO330;

import java.math.BigInteger;

public class t2 {
  public static void main(String[] args) {
    monkeyMove(10);
  }
  static int mod = (int) 1e9 + 7;
  public static int monkeyMove(int n) {
    long res = quickPow(2, n);
    return (int) (res + mod - 2) % mod;
  }

  // n == 10

  static long quickPow(int x, int n) {
    long res = 1, cur = x;
    while (n > 0) {
      // if pow is odd
      if ((n & 1) == 1) {
        res = (res * cur) % mod;
      }
      cur = (cur * cur) % mod;
      n /= 2;
    }
    return res;
  }
}
