package A_OnsiteClassical.Tiktok;

public class NO91_DecodeWays {
  public int numDecodings(String s) {
    if (s.charAt(0) == '0') {
      return 0;
    }
    int n = s.length();
    int[] dp = new int[n + 1];
    dp[0] = 1;

    for (int i = 1; i <= n; ++i) {
      // if (s.charAt(i - 1) == '0') {
      //     if (s.charAt(i - ) != '1' && s.charAt(i - 1) != '2') {
      //         return 0;
      //     }
      // }
      if (s.charAt(i - 1) != '0') {
        dp[i] += dp[i - 1];
      }
      if (i > 1 && s.charAt(i - 2) != '0' && Integer.parseInt(s.substring(i - 2, i)) <= 26) {
        dp[i] += dp[i - 2];
      }
    }
    // System.out.println(Arrays.deepToString(dp));

    return dp[n];
  }
}
