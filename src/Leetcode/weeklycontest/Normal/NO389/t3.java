package Leetcode.weeklycontest.Normal.NO389;

import java.util.TreeMap;

public class t3 {
    public int minimumDeletions(String word, int k) {
        int[] cnt = new int[26];
        for (char c : word.toCharArray()) {
            cnt[c - 'a']++;
        }

        // <freq , freq time>
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int c : cnt) {
            if (c != 0) {
                map.merge(c, 1, Integer::sum);
            }
        }

        int res = 0;

        while (true) {
            if (map.size() == 1) {
                return res;
            }

            int first = map.firstKey(), last = map.lastKey();
            if (last - first <= k) {
                return res;
            }

            // require process

            if (map.get(first) > map.get(last)) {
                res += map.get(last);
                map.remove(last);
            } else if (map.get(first) >= map.get(last)) {
                res += map.get(first);
                map.remove(first);
            }
        }

        return res;
    }
}
