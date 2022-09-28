package AmazonOA.former;

import java.util.Arrays;
import java.util.LinkedList;

public class mergeInterval {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();

        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int[] last = res.getLast();
            if (cur[0] <= last[1]) {
                last[1] = Math.max(last[1], cur[1]);
            } else {
                res.add(cur);
            }
        }
        return res.toArray(new int[0][0]);
    }
}
