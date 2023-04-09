package BISHI.Amazon.former;

import java.util.Arrays;

public class InterleavingString {
    int[][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) return false;
        memo = new int[m + 1][n + 1];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(s1, 0, s2, 0, s3);
    }

    boolean dp(String s1, int i, String s2, int j, String s3) {
        int k = i + j;
        if (k == s3.length()) return true;

        if (memo[i][j] != -1) return memo[i][j] == 1;

        boolean res = false;
        if (i < s1.length() && s3.charAt(k) == s1.charAt(i)) {
            res = dp(s1, i + 1, s2, j, s3);
        }
        if (j < s2.length() && s3.charAt(k) == s2.charAt(j)) {
            res = res || dp(s1, i, s2, j + 1, s3);
        }

        memo[i][j] = res ? 1 : 0;

        return res;
    }
}
