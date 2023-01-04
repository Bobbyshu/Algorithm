package Algorithm_Carl.Backtrace.partition;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> res;
    LinkedList<String> path;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        backtrace(s, 0);
        return res;
    }

    void backtrace(String s, int startIndex) {
        if (startIndex >= s.length()) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); ++i) {
            if (isPalindrome(s, startIndex, i)) {
                String seg = s.substring(startIndex, i + 1);
                path.add(seg);
            } else {
                continue;
            }
            backtrace(s, i + 1);
            path.removeLast();
        }
    }

    boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
