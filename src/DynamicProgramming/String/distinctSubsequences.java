package DynamicProgramming.String;

import java.util.Arrays;

/*
Given two strings s and t, return the number of distinct subsequences of s which equals t.

A string's subsequence is a new string formed from the original string by deleting some
(can be none) of the characters without disturbing the remaining characters' relative positions.
(i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).

The test cases are generated so that the answer fits on a 32-bit signed integer.
 */
/*
抓住 “选”，s 要照着 t 来挑选，逐字符考察选或不选，分别来到什么状态？

举例，s为babgbag，t为bag，末尾字符相同，于是 s 有两种选择：

用s[s.length-1]去匹配掉t[t.length-1]，问题规模缩小：继续考察babgba和ba
不这么做，但t[t.length-1]仍需被匹配，于是在babgba中继续挑，考察babgba和bag
 */
public class distinctSubsequences {
    int m, n;
    int[][] memo;
    public int numDistinct(String s, String t) {
        m = s.length();
        n = t.length();
        if (m < n)
            return 0;

        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(s, m - 1, t, n - 1);
    }

    int dp(String s, int i, String t, int j) {
        if (j < 0)
            return 1;

        if (i < 0 || t.length() - j > s.length() - i) return 0;

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {
            memo[i][j] = dp(s, i - 1, t, j) + dp(s, i - 1, t, j - 1);
        } else {
            memo[i][j] = dp(s, i - 1, t, j);
        }

        return memo[i][j];
    }

}

class Solution {
    int[][] memo;
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) return 0;
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(s, 0, t, 0);
    }

    int dp(String s1, int i, String s2, int j) {
        if (j == s2.length()) return 1;
        if (s2.length() - j > s1.length() - i) return 0;

        if (memo[i][j] != -1) return memo[i][j];

        if (s1.charAt(i) != s2.charAt(j)) {
            memo[i][j] = dp(s1, i + 1, s2, j);
        } else {
            memo[i][j] = dp(s1, i + 1, s2, j + 1) + dp(s1, i + 1, s2, j);
        }

        return memo[i][j];
    }
}

