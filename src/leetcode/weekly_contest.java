package leetcode;

import java.util.ArrayList;
import java.util.List;

public class weekly_contest {
    public static void main(String[] args) {
        weekly_contest wee = new weekly_contest();
        wee.maximumEvenSplit(28);
        System.out.println(wee.maximumEvenSplit(12));
    }

    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> ans = new ArrayList<>();
        if ((finalSum & 1) == 0) {
            long k = 2;
            while (true) {
                if (finalSum == k) {
                    ans.add(k);
                    break;
                } else if (finalSum < k) {
                    ans.add(ans.remove(ans.size() - 1) + finalSum);
                    break;
                } else {
                    ans.add(k);
                    finalSum -= k;
                    k += 2;
                }
            }
        }
        return ans;
    }
}
