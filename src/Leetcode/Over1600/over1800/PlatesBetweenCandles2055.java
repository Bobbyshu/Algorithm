package Leetcode.Over1600.over1800;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlatesBetweenCandles2055 {
    public int[] platesBetweenCandlesPrefix(String s, int[][] queries) {
        int n = s.length(), m = queries.length;
        int[] left = new int[n], right = new int[n];

        Arrays.fill(left, -1);
        Arrays.fill(right, -1);

        left[0] = s.charAt(0) == '|' ? 0 : -1;
        for (int i = 1; i < n; ++i) {
            left[i] = s.charAt(i) == '|' ? i : left[i - 1];
        }

        right[n - 1] = s.charAt(n - 1) == '|' ? n - 1 : -1;
        for (int i = n - 2; i >= 0; --i) {
            right[i] = s.charAt(i) == '|' ? i : right[i + 1];
        }

        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));

        int[] prefix = new int[n];
        prefix[0] = s.charAt(0) == '*' ? 1 : 0;
        for (int i = 1; i < n; ++i) {
            prefix[i] = s.charAt(i) == '*' ? prefix[i - 1] + 1 : prefix[i - 1];
        }

        int[] res = new int[m];
        for (int i = 0; i < m; ++i) {
            int[] q = queries[i];
            int leftCandle = right[q[0]], rightCandle = left[q[1]];
            if (leftCandle == -1 || rightCandle == -1 || leftCandle >= rightCandle) {
                continue;
            }

            res[i] = prefix[rightCandle] - prefix[leftCandle];
        }

        return res;
    }
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
