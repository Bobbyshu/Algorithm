package Leetcode.weeklycontest.Normal.NO389;

import java.util.Arrays;
import java.util.TreeMap;

public class t3 {
    public int minimumDeletions(String word, int k) {
        int[] cnt = new int[26];
        for (char c : word.toCharArray()) {
            cnt[c - 'a']++;
        }

//        Arrays.sort(cnt);

        // there must be a character can be exempted from deleting
        // because if we delete each character 1
        // it equals to we add each character 1
        // both will not influence the gap between the most and least freq
        // So, we can enumerate the available freq

        // enumerate the available minimum freq
        int save = 0;
        for (int i = 0; i < 26; ++i) {
            int sum = 0;
            for (int j = 0; j < 26; ++j) {
                if (cnt[j] < cnt[i]) {
                    continue;
                }

                sum += Math.min(cnt[j], cnt[i] + k);
            }
            save = Math.max(save, sum);
        }

        return word.length() - save;
    }
}
