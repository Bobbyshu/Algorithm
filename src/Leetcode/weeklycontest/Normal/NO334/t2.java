package Leetcode.weeklycontest.Normal.NO334;

public class t2 {
  public int[] divisibilityArray(String word, int m) {
    int n = word.length();
    int[] res = new int[n];
    long prefix = 0;
    for (int i = 0; i < n; i++) {
      int digit = word.charAt(i) - '0';
      prefix = (prefix * 10 + digit) % m;
      res[i] = (prefix == 0) ? 1 : 0;
    }
    return res;
  }
}
