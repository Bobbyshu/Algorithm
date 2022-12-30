package GuCheng.FundmentalAlgo.A_ScanLine;
/*
Given an array of meeting room intervals consisting of start and end times
find the minimum number of conference rooms required
 */

import java.util.*;

public class MeetingRoomTwo {
    public int minMeetingRooms1(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for (int[] gap : intervals) {
            list.add(new int[]{gap[0], 1});
            list.add(new int[]{gap[1], -1});
        }

        Collections.sort(list, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int res = 0, cnt = 0;
        for (int[] point : list) {
            cnt += point[1];
            res = Math.max(res, cnt);
        }

        return res;
    }

    public int minMeetingRooms2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        if (intervals.length != 0) {
            heap.offer(intervals[0]);
        }

        for (int i = 1; i < intervals.length; ++i) {
            int[] cur = heap.poll();
            //cur meeting room has finished when the 2nd meeting start
            if (cur[1] <= intervals[i][0]) {
                //from cur[0] to intervals[1] there's only one meeting room required
                cur[1] = intervals[i][1];
            } else {
                heap.offer(intervals[i]);
            }
            //add back
            heap.offer(cur);
        }

        return heap.size();
    }
}
