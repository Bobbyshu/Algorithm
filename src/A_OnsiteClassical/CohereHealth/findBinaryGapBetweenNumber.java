package A_OnsiteClassical.CohereHealth;

import java.util.ArrayList;
import java.util.List;

public class findBinaryGapBetweenNumber {
    // Find the binary gap of a number N 求一个数二进制的最大间隔，和领口868类似
    public int binaryGap(int n) {
        String s = Integer.toBinaryString(n);
        List<Integer> lst = new ArrayList<>();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '1') {
                lst.add(i);
            }
        }

        if (lst.size() < 2) {
            return 0;
        }

        int res = 0;
        for (int i = 1; i < lst.size(); ++i) {
            res = Math.max(res, lst.get(i) - lst.get(i - 1));
        }

        return res;
    }
}
