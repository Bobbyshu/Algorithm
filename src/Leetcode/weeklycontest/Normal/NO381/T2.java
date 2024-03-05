package Leetcode.weeklycontest.Normal.NO381;

import java.util.ArrayDeque;
import java.util.Deque;

public class T2 {
    public int[] countOfPairs(int n, int x, int y) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                int direct = j - i;
                int crossX = Math.abs(i - x) + 1 + Math.abs(j - y);
                int crossY = Math.abs(i - y) + 1 + Math.abs(j - x);
                int idx = Math.min(direct, Math.min(crossX, crossY));
                res[idx] += 2;
            }
        }

        int[] ret = new int[n];
        System.arraycopy(res, 1, ret, 0, n);

        return ret;
    }
}
