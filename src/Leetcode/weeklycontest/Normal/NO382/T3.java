package Leetcode.weeklycontest.Normal.NO382;

public class T3 {
  public long flowerGame(int n, int m) {
    long oddN = 0, evenN = 0, oddM = 0, evenM = 0;

    long[] evenOdd = divide((long) n), evenOdd2 = divide((long) m);
    evenN = evenOdd[0];
    oddN = evenOdd[1];
    evenM = evenOdd2[0];
    oddM = evenOdd2[1];

    return evenN * oddM + evenM * oddN;
  }

  long[] divide(long n) {
    if (n % 2 == 0) {
      return new long[]{n / 2, n / 2};
    } else {
      return new long[]{n / 2, (n + 1) / 2};
    }
  }
}
