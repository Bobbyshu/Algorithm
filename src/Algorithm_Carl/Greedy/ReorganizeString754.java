package Algorithm_Carl.Greedy;

import java.util.PriorityQueue;

/*
在一根无限长的数轴上，你站在0的位置。终点在target的位置。

你可以做一些数量的移动 numMoves :

每次你可以选择向左或向右移动。
第 i 次移动（从  i == 1 开始，到 i == numMoves ），在选择的方向上走 i 步。
给定整数 target ，返回 到达目标所需的 最小 移动次数(即最小 numMoves ) 。


 */
public class ReorganizeString754 {
    public String reorganizeString(String s) {
        int[] cnt = new int[26];
        int maxCnt = 0, n = s.length();
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
            maxCnt = Math.max(maxCnt, cnt[c - 'a']);
        }

        if (maxCnt > (n + 1) / 2) {
            return "";
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((o1, o2) -> cnt[o2 - 'a'] - cnt[o1 - 'a']);
        for (int i = 0; i < 26; ++i) {
            if (cnt[i] > 0) {
                pq.offer((char) (i + 'a'));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (pq.size() > 1) {
            char c = pq.poll(), d = pq.poll();

            sb.append(c).append(d);

            --cnt[c - 'a'];
            --cnt[d - 'a'];
            if (cnt[c - 'a'] > 0) {
                pq.offer(c);
            }

            if (cnt[d - 'a'] > 0) {
                pq.offer(d);
            }
        }

        if (!pq.isEmpty()) {
            sb.append(pq.poll());
        }

        return sb.toString();
    }
}
