package Leetcode.weeklycontest.Normal.NO385;

import java.util.HashSet;
import java.util.Set;

public class t2 {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<String> set = new HashSet<>();
        for (int s : arr1) {
            String str = String.valueOf(s);
            for (int i = 1; i <= str.length(); ++i) {
                String prefix = str.substring(0, i);
                set.add(prefix);
            }
        }
        int res = 0;

        for (int a : arr2) {
            String s = String.valueOf(a);
            for (int i = 1; i <= s.length(); ++i) {
                String prefix = s.substring(0, i);
                if (set.contains(prefix)) {
                    res = Math.max(res, i);
                }
            }
        }

        return res;
    }
}
