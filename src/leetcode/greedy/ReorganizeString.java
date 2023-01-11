package leetcode.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ReorganizeString {
    public String reorganizeString(String s) {
        if (s.length() == 1) {
            return s;
        }

        int[] cnt = new int[26];
        int maxFreq = 0, n = s.length();

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
            maxFreq = Math.max(maxFreq, cnt[c - 'a']);
        }

        //even all the maxFreq char insert alternatively we cant get the string
        if (maxFreq > (n + 1) / 2) {
            return "";
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((o1, o2) -> cnt[o2 - 'a'] - cnt[o1 - 'a']);

        for (int i = 0; i < 26; ++i) {
            if (cnt[i] > 0) {
                pq.offer((char) (i + 'a'));
            }
        }

        StringBuilder sb = new StringBuilder();

        while (pq.size() >= 2) {
            char c1 = pq.poll(), c2 = pq.poll();
            sb.append(c1).append(c2);
            int p1 = c1 - 'a', p2 = c2 - 'a';
            --cnt[p1];
            --cnt[p2];
            if (cnt[p1] > 0) {
                pq.offer(c1);
            }

            if (cnt[p2] > 0) {
                pq.offer(c2);
            }
        }

        if (!pq.isEmpty()) {
            sb.append(pq.poll());
        }

        return sb.toString();
    }
}
