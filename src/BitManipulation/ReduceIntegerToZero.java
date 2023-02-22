package BitManipulation;

public class ReduceIntegerToZero {
  public static void main(String[] args) {
    minOperations(39);
  }

  public static int minOperations(int n) {
    int res = 0;
    while (n != 0) {
      if (n == 1) {
        return res + 1;
      }
      // check whether isn't pow of 2
      if ((n & 1) == 1) {
        // -1 to change low bit
        if (Integer.bitCount(n - 1) < Integer.bitCount(n + 1)) {
          --n;
        } else {
          ++n;
        }
      }
      // solve low bit and right forward
      n >>= 1;
      ++res;
    }
    return res;
  }
}
