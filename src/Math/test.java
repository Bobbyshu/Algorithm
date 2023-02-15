package Math;
// leetcode 1638
public class test {
  public static void main(String[] args) {
    countSubstrings("aba", "baba");
  }
  public static int countSubstrings(String s, String t) {
    int m = s.length(), n = t.length(), res = 0;
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        int diff = 0;
        for (int k = 0; i + k < m && j + k < n; ++k) {
          if (s.charAt(i + k) != t.charAt(j + k)) {
            diff += 1;
          }
          if (diff > 1) {
            break;
          }
          if (diff == 1) {
            ++res;
          }
        }
      }
    }
    return res;
  }
}
