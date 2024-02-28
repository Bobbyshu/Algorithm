package Leetcode.weeklycontest.Normal.NO380;

import java.util.ArrayList;
import java.util.List;

public class T4 {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        char[] arr = s.toCharArray();

        List<Integer> posA = process(arr, a.toCharArray());
        List<Integer> posB = process(arr, b.toCharArray());
        List<Integer> res = new ArrayList<>();
        if (posA.isEmpty() || posB.isEmpty()) {
            return res;
        }

        // System.out.println(map);

        for (int i : posA) {
            int idx1 = right_bound(posB, i);
            int idx2 = left_bound(posB, i);
            // System.out.println(idx);
            if (Math.abs(posB.get(idx1) - i) <= k
                    || Math.abs(posB.get(idx2) - i) <= k) {
                res.add(i);
            }
        }

        return res;
    }

    private List<Integer> process(char[] text, char[] pattern) {
        int m = pattern.length;
        int[] pi = new int[m];
        int c = 0;
        for (int i = 1; i < m; i++) {
            char v = pattern[i];
            while (c > 0 && pattern[c] != v) {
                c = pi[c - 1];
            }
            if (pattern[c] == v) {
                c++;
            }
            pi[i] = c;
        }

        List<Integer> res = new ArrayList<>();
        c = 0;
        for (int i = 0; i < text.length; i++) {
            char v = text[i];
            while (c > 0 && pattern[c] != v) {
                c = pi[c - 1];
            }
            if (pattern[c] == v) {
                c++;
            }
            if (c == m) {
                res.add(i - m + 1);
                c = pi[c - 1];
            }
        }
        return res;
    }

    private int right_bound(List<Integer> lst, int target) {
        int l = 0, r = lst.size() - 1;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (lst.get(mid) <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private int left_bound(List<Integer> lst, int target) {
        int l = 0, r = lst.size() - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (lst.get(mid) >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
