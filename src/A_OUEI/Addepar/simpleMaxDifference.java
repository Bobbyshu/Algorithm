package A_OUEI.Addepar;

import java.util.List;

public class simpleMaxDifference {
    public static int maxDiff(List<Integer> px) {
        int len = px.size();
        int[] suffix = new int[len];

        suffix[len - 1] = px.get(len - 1);
        for (int i = len - 2; i >= 0; i--) {
            suffix[i] = Math.max(px.get(i), suffix[i + 1]);
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, suffix[i] - px.get(i));
        }

        return res == 0 ? -1 : res;
    }
}
