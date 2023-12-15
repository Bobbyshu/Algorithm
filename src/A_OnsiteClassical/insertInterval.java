package A_OnsiteClassical;

import java.util.ArrayList;
import java.util.List;

public class insertInterval {
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
