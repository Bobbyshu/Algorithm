package Algorithm_Carl.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] cnt = new int[26];
        char[] arr = s.toCharArray();
        int l = 0, r = 0, res = 0;
        while (r < s.length()) {
            cnt[arr[r] - 'A']++;
            res = Math.max(res, cnt[arr[r] - 'A']);
            while (r - l + 1 > res + k) {
                cnt[arr[l] - 'A']--;
                ++l;
            }

            ++r;
        }

        return s.length() - l;
    }
}
