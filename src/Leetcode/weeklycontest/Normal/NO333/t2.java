package Leetcode.weeklycontest.Normal.NO333;

public class t2 {
  public static void main(String[] args) {
  }
  public static int minOperations(int n) {
    int count = 0;
    while (n != 0) {
      if ((n & 1) == 1) {
        if (n == 1 || Integer.bitCount(n - 1) < Integer.bitCount(n + 1)) {
          n--;
        } else {
          n++;
        }
        count++;
      }
      n >>= 1;
    }
    return count;
  }
}
