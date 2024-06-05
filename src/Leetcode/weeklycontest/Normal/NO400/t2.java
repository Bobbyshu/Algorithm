package Leetcode.weeklycontest.Normal.NO400;

import java.util.Arrays;

public class t2 {
  public int countDays(int days, int[][] meetings) {
    Arrays.sort(meetings, (o1, o2) -> o1[0] - o2[0]);
    System.out.println(Arrays.deepToString(meetings));
    int res = 0;
    int preRight = meetings[0][1];
    // previous day
    res += meetings[0][0] - 1;

    for (int i = 1; i < meetings.length; ++i) {
      if (meetings[i][0] > preRight) {
        res += meetings[i][0] - preRight - 1;
      }
      preRight = Math.max(meetings[i][1], preRight);
    }

    // remain day
    res += days - preRight;

    return res;
  }
}
