package Leetcode.weeklycontest.Normal.NO384;

import java.util.Arrays;

public class t3 {
    public int maxPalindromesAfterOperations(String[] words) {
        int[] cnt = new int[26];
        int total = 0;
        for (String s : words) {
            for (char c : s.toCharArray()) {
                cnt[c - 'a']++;
                ++total;
            }
        }

        int pairs = 0;
        for (int i : cnt) {
            pairs += i / 2;
        }

        int single = total - 2 * pairs;

        // greedy
        Arrays.sort(words, (o1, o2) -> o1.length() - o2.length());
        int res = 0;

        for (String s : words) {
            int cur = s.length();
            // if string is n * pairs
            // just divide them
            if (cur % 2 == 0) {
                if (pairs * 2 >= cur) {
                    pairs -= cur / 2;
                    ++res;
                }
            } else {
                // string is n * pairs + 1
                // we can make sure that everytime pairs * 2 + single will greater than cur length
                // because single + 2 * pairs will equals to total length
                // so it will always greater than or equals to cur length
                if (pairs * 2 >= cur - 1) { // pairs enough
                    if (single > 0) {
                        pairs -= (cur - 1) / 2;
                        --single;
                    } else {
                        pairs -= (cur + 1) / 2;
                        ++single;
                    }
                    ++res;
                }
            }
        }

        return res;
    }
}
