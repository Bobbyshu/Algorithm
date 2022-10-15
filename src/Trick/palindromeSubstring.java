package Trick;

import java.util.ArrayList;
import java.util.List;

public class palindromeSubstring {
    public static List<String> funcSubstring(String str) {
        int n = str.length();
        List<String> list = new ArrayList<>();
        boolean[][] dp = new boolean[n][n];

        //dp[i][j] means that whether s is Palindromic Substrings between [i, j]
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (str.charAt(i) == str.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && dp[i][j]) {
                    list.add(str.substring(i, j + 1));
                }
            }
        }

        return list;
    }
}
