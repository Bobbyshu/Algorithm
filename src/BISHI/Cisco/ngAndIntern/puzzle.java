package BISHI.Cisco.ngAndIntern;

import java.util.ArrayList;
import java.util.List;

public class puzzle {
    public static void main(String[] args) {
        String s = "A";
        funcSubstring(s);
    }
    public static String funcSubstring(String inputStr) {

        int n = inputStr.length();
        List<String> list = new ArrayList<>();
        boolean[][] dp = new boolean[n][n];

        //dp[i][j] means that whether s is Palindromic Substrings between [i, j]
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (inputStr.charAt(i) == inputStr.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && dp[i][j]) {
                    list.add(inputStr.substring(i, j + 1));
                }
            }
        }

        if (list.size() < 2) {
            return "None";
        }

        String s = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (lexi(s, list.get(i))) {
                s = list.get(i);
            }
        }
        return s;
    }

    static boolean lexi(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int i = 0;
        while (i < m && i < n) {
            if (s1.charAt(i) > s2.charAt(i)) {
                return true;
            } else if (s1.charAt(i) < s2.charAt(i)) {
                return false;
            } else {
                i++;
            }
        }

        return i != m;
    }
}
