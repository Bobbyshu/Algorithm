package GuCheng.FundmentalAlgo.A_ScanLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals);

        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] <= list.get(list.size() - 1)[1]) {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], intervals[i][1]);
            } else {
                list.add(intervals[i]);
            }
        }

        return list.toArray(new int[0][]);
    }
}
