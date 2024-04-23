package Leetcode.weeklycontest.Normal.NO394;

import java.util.Arrays;

public class t2 {
    public int numberOfSpecialChars(String word) {
        int[] last = new int[26], first = new int[26];
        Arrays.fill(last, -1);
        Arrays.fill(first, -1);
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (c <= 'z' && c >= 'a') {
                last[c - 'a'] = i;
            } else {
                if (first[c - 'A'] == -1) {
                    first[c - 'A'] = i;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < 26; ++i) {
            if (last[i] != -1 && first[i] != -1 && last[i] < first[i]) {
                ++res;
            }
        }

        return res;
    }
}
