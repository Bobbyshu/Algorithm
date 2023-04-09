package Algorithm_Carl.DynamicProgramming.String;

import java.util.Arrays;

public class ShortestCommonSupersequence {
  public static void main(String[] args) {
    String a = "aaa";
    String b = "aaa";
    shortestCommonSupersequence(a, b);
  }
  public static String shortestCommonSupersequence(String str1, String str2) {
    int m = str1.length(), n = str2.length();
    int[][] dp = new int[m + 1][n + 1];
    char[] s1 = str1.toCharArray(), s2 = str2.toCharArray();
    for (int i = 1; i <= m; ++i) {
      for (int j = 1; j <= n; ++j) {
        if (s1[i - 1] == s2[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    int i = m, j = n;
    while (i > 0 && j > 0) {
      if (s1[i - 1] == s2[j - 1]) {
        sb.append(s1[i - 1]);
        --i;
        --j;
      } else if (dp[i][j] == dp[i - 1][j]) {
        sb.append(s1[i - 1]);
        --i;
      } else {
        sb.append(s2[j - 1]);
        --j;
      }
    }

    while (i > 0) {
      sb.append(s1[i - 1]);
      --i;
    }

    while (j > 0) {
      sb.append(s2[j - 1]);
      --j;
    }

    return sb.reverse().toString();
  }
}
