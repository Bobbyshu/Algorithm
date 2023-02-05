package Math;

public class quickPow {
  int mod = (int) 1e9 + 7;
  // cal a^b in log(N)
  // a for registering odd power
  // b for registering even power
  // res for calculating a^b
  long quickPow(long a, long b) {
    long res = 1;
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
