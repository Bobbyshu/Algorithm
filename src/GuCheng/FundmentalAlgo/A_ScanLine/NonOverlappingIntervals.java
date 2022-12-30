package GuCheng.FundmentalAlgo.A_ScanLine;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        // System.out.println(Arrays.deepToString(intervals));
        int cnt = 0, end = Integer.MIN_VALUE;

        for (int[] cur : intervals) {
            if (end <= cur[0]) {
                end = cur[1];
            } else {
                cnt++;
            }
        }

        return cnt;
    }
}
