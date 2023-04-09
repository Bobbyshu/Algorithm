package Trick;

public class bit_transfer_negative {
  public String baseNeg2(int n) {
    return getString(n, -2);
  }

  // 同余关系，保证余数为非负数
  private String getString(int n, int k) {
    if (n == 0) {
      return "0";
    }
    StringBuilder sb = new StringBuilder();
    while (n != 0) {
      int r = ((n % k) + Math.abs(k)) % Math.abs(k);
      sb.append(r);
      n -= r;
      n /= k;
    }
    return sb.reverse().toString();
  }

  // second way
  public String baseNeg2Second(int N) {
    StringBuilder res = new StringBuilder();
    while (N != 0) {
      res.append(N & 1);
      N = -(N >> 1);
    }
    return res.length() > 0 ? res.reverse().toString() : "0";
  }
}
