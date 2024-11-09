package A_OnsiteClassical.Tiktok;

public class NO5_LongestPalindromicSubstring {
  public String longestPalindrome(String s) {
    int n = s.length();
    int resLeft = -1, resRight = n;
    int curLength = 1;

    for (int i = 0; i < n; ++i) {
      int[] ret = check(s, i, i);
      if (ret[1] - ret[0] + 1 > curLength) {
        resLeft = ret[0];
        resRight = ret[1];
        curLength = ret[1] - ret[0] + 1;
      }
      // System.out.println("i = " + i);
      // System.out.println(Arrays.toString(ret));


      ret = check(s, i, i + 1);
      if (ret[1] - ret[0] + 1 > curLength) {
        resLeft = ret[0];
        resRight = ret[1];
        curLength = ret[1] - ret[0] + 1;
      }
    }

    return resLeft == -1 ? s.substring(0, 1) : s.substring(resLeft, resRight + 1);
  }

  private int[] check(String s, int l, int r) {
    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
      --l;
      ++r;
    }

    return new int[]{l + 1, r - 1};
  }
}
