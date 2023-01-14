package GuCheng.Fundmental.Algo.A_ScanLine;

import java.util.ArrayList;
import java.util.List;
/*
You are given an array of non-overlapping intervals
where intervals[i] = [starti, endi] represent the start and the end of the ith interval
and intervals is sorted in ascending order by starti.
You are also given an
interval newInterval = [start, end] that represents the start and end of another interval.
Insert newInterval into intervals such that intervals
is still sorted in ascending order by starti
and intervals still does not have any overlapping intervals
(merge overlapping intervals if necessary).

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Return intervals after the insertion.
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] res = new int[1][2];
            res[0] = newInterval;
            return res;
        }

        List<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            ++i;
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            ++i;
        }

        list.add(newInterval);
        while (i < intervals.length) {
            list.add(intervals[i]);
            ++i;
        }

        return list.toArray(new int[0][]);
    }
}
