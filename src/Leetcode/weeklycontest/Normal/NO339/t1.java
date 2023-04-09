package Leetcode.weeklycontest.Normal.NO339;

public class t1 {
  public static void main(String[] args) {
    findTheLongestBalancedSubstring("01000111");
  }
  public static int findTheLongestBalancedSubstring(String s) {
    int n = s.length(), res = 0;
    for (int i = 0; i < n; ++i) {
      int cntOne = 0, cntZero = 0;
      for (int j = i; j < n; ++j) {
        if (s.charAt(j) == '1') {
          ++cntOne;
        } else {
          if (cntOne != 0) {
            cntOne = 0;
            cntZero = 0;
          }
          ++cntZero;
          continue;
        }

        if (cntOne == cntZero) {
          res = Math.max(res, cntOne + cntZero);
        }
      }
    }
    return res;
  }
}
