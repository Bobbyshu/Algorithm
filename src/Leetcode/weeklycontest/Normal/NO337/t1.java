package Leetcode.weeklycontest.Normal.NO337;

public class t1 {
  public int[] evenOddBit(int n) {
    String s = getString(n, 2);
//    System.out.println(s);
    int even = 0, odd = 0;
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) == '1') {
        if (i % 2 == 0) {
          even++;
        } else {
          odd++;
        }
      }
    }

    return new int[]{even, odd};
  }

  private String getString(int n, int i) {
    StringBuilder sb = new StringBuilder();
    while (n != 0) {
      sb.append(n % i);
      n /= i;
    }
    return sb.toString();
  }
}
