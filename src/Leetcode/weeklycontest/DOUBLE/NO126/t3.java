package Leetcode.weeklycontest.DOUBLE.NO126;

import java.util.ArrayList;
import java.util.List;

public class t3 {
    // abcdefghijklmnopqrstuvwxy??
    // abcdefghijklmnopqrstuvwxyaz
    // eq?umjlasi
    public String minimizeStringValue(String s) {
        int[] cnt = new int[26];
        List<Character> dict = new ArrayList<>();

        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c != '?') {
                cnt[c - 'a']++;
            }
        }

        for (char a : arr) {
            if (a != '?') {
                continue;
            }

            int minIdx = -1, min = Integer.MAX_VALUE;
            for (int j = 0; j < 26; ++j) {
                if (cnt[j] < min) {
                    min = cnt[j];
                    minIdx = j;
                }
            }
            ++cnt[minIdx];
            char c = (char) (minIdx + 'a');
            dict.add(c);
        }

        // 可以排序，因为是已知的最好结果来排序，不会影响已知的最好结果
        dict.sort((o1, o2) -> o1.compareTo(o2));
        int idx = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == '?') {
                arr[i] = dict.get(idx++);
            }
        }


        return new String(arr);
    }
}
