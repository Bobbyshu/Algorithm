package A_OnsiteClassical.Tiktok;

import java.util.Arrays;
import java.util.PriorityQueue;

public class meetingRoomTwo253 {
  // 先对所有的区间按照开始时间进行排序，使用小根堆保存每个会议的结束时间，
  // 要申请会议室的时候，先看是不是可以释放会议室，将已经占用的会议室释放
  public int minMeetingRooms(int[][] intervals) {
    Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

    PriorityQueue<int[]> occupied = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
    for (int[] interval : intervals) {
      if (!occupied.isEmpty() && interval[0] >= occupied.peek()[1]) {
        occupied.poll();
      }
      occupied.add(interval);
    }
    return occupied.size();
  }
}
