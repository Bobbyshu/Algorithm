package Leetcode.weeklycontest.Normal.NO380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T2 {

    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        Map<String, List<Integer>> map = new HashMap<>();
        map.put(a, new ArrayList<>());

        // if equals, each idx is legal
        if (a.equals(b)) {
            process(map, s, a);
            return map.get(a);
        }

        map.put(b, new ArrayList<>());
        process(map, s, a);
        process(map, s, b);
        List<Integer> res = new ArrayList<>();
        if (map.get(a).isEmpty() || map.get(b).isEmpty()) {
            return res;
        }

        // System.out.println(map);

        for (int i : map.get(a)) {
            int idx1 = right_bound(map.get(b), i);
            int idx2 = left_bound(map.get(b), i);
            // System.out.println(idx);
            if (Math.abs(map.get(b).get(idx1) - i) <= k
                    || Math.abs(map.get(b).get(idx2) - i) <= k) {
                res.add(i);
            }
        }




        return res;
    }

    private void process(Map<String, List<Integer>> map, String s, String t) {
        int m = s.length(), n = t.length();
        for (int i = 0; i < m; ++i) {
            if (s.charAt(i) == t.charAt(0)) {
                if (i + n <= m && s.startsWith(t, i)) {
                    map.get(t).add(i);
                }
            }
        }
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
