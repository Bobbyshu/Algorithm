package Leetcode.weeklycontest.Normal.NO381;

import java.util.Arrays;

public class T3 {

    public int minimumPushes(String word) {
        int[] cnt = new int[26];
        for (char c : word.toCharArray()) {
            cnt[c - 'a']++;
        }

        int res = 0;
        Arrays.sort(cnt);

        int start = 1;
        for (int i = 25; i >= 0; --i) {
            if (i < 18 && i >= 10) {
                start = 2;
            } else if (i < 10 && i >= 2) {
                start = 3;
            } else if (i < 2) {
                start = 4;
            }
            res += start * cnt[i];
        }

        return res;
    }

}
