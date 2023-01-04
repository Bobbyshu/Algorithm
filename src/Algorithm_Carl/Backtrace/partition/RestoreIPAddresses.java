package Algorithm_Carl.Backtrace.partition;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12)
            return res;

        backtrace(s, 0, 0);
        return res;
    }

    void backtrace(String s, int startIndex, int dotNum) {
        if (dotNum == 3 && check(s, startIndex, s.length() - 1)) {
            res.add(s);
            return;
        }

        for (int i = startIndex; i < s.length(); ++i) {
            if (check(s, startIndex, i)) {
                // add dot
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                backtrace(s, i + 2, dotNum + 1);
                // remove dot
                s = s.substring(0, i + 1) + s.substring(i + 2);
            } else {
                break;
            }
        }
    }

    boolean check(String s, int i, int j) {
        if (i > j)
            return false;

        if (j != i && s.charAt(i) == '0')
            return false;

        int num = 0;
        for (int k = i; k <= j; ++k) {
            //avoid !Character.isDigit()
            if (s.charAt(k) > '9' || s.charAt(k) < '0') {
                return false;
            }

            num = num * 10 + (s.charAt(k) - '0');
            if (num > 255) {
                return false;
            }
        }

        return true;
    }
}
