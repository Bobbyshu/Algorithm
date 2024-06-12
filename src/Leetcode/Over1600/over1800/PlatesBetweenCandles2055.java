package Leetcode.Over1600.over1800;

import java.util.ArrayList;
import java.util.List;

public class PlatesBetweenCandles2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        List<Integer> lst = new ArrayList<>();
        int n = s.length(), m = queries.length;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '|') {
                lst.add(i);
            }
        }

        int[] res = new int[m];
        if (lst.size() < 2) {
            return res;
        }
        // System.out.println(lst);

        // int[] res = new int[m];
        for (int i = 0; i < m; ++i) {
            int[] q = queries[i];
            // find the
            int leftIdx = left_bound(lst, q[0]), rightIdx = right_bound(lst, q[1]);
            int between = rightIdx - leftIdx - 1;
            res[i] = lst.get(rightIdx) - lst.get(leftIdx) - 1 - between;
            if (res[i] < 0) {
                res[i] = 0;
            }
            // System.out.println(leftIdx);
            // System.out.println(rightIdx);
        }

        return res;
    }

    // return the left_bound equals to target or the first number larger than target
    private int left_bound(List<Integer> lst, int target) {
        int l = 0, r = lst.size() - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (lst.get(mid) >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    // return the right_bound equals to target or the first number smaller than target
    private int right_bound(List<Integer> lst, int target) {
        int l = 0, r = lst.size() - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (lst.get(mid) <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }
}
