package Algorithm_Carl.BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class ListArraySearch {
    public static void main(String[] args) {
        String s = "abcde";
        String[] ss = {"a","bb","acd","ace"};
        System.out.println(numMatchingSubsequence(s, ss));
    }
    public static int numMatchingSubsequence(String s, String[] words) {
        List<Integer>[] pos = new List[26];

        for (int i = 0; i < s.length(); i++) {
            if (pos[i] == null)
                pos[i] = new ArrayList<>();
            pos[s.charAt(i) - 'a'].add(i);
        }

        int res = words.length;
        for (String w : words) {
            if (w.length() > s.length()) {
                res--;
                continue;
            }

            int p1 = -1;
            for (int i = 0; i < w.length(); i++) {
                List<Integer> cur = pos[w.charAt(i) - 'a'];
                if (cur.isEmpty() || cur.get(cur.size() - 1) <= p1) {
                    res--;
                    break;
                }
                p1 = right_bound(cur, p1);
            }
        }

        return res;
    }

    public static int right_bound(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return list.get(left);
    }
}
