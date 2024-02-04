package Leetcode.weeklycontest.Normal.NO383;

public class T4 {
  public static void main(String[] args) {
    int res = minimumTimeToInitialState("aab", 2);
    int res1 = minimumTimeToInitialState("abacaba", 3);
    int res2 = minimumTimeToInitialState("abacaba", 4);
    int res3 = minimumTimeToInitialState("abcbabcd", 2);
    System.out.println(res);
    System.out.println(res1);
    System.out.println(res2);
    System.out.println(res3);
  }
  public static int minimumTimeToInitialState(String word, int k) {
    if (k == word.length()) {
      return 1;
    }

    String pattern = word.substring(0, k);

    int n = word.length();
    int cnt = 1;
    for (int i = k; i < n; i += k) {
      if (i + k > n) {
        String remain = word.substring(i);
        int len = remain.length();
        String compare = word.substring(0, len);
        if (remain.equals(compare)) {
          return cnt;
        } else {
          return cnt + 1;
        }
      }

      String cur = word.substring(i, i + k);
      if (cur.equals(pattern)) {
        if (i + k == n) {
          return cnt;
        } else {
          String remain = word.substring(i);
          int len = remain.length();
          String compare = word.substring(0, len);
          if (remain.equals(compare)) {
            return cnt;
          }
        }
      }
      ++cnt;
    }

    return cnt;
  }
}
