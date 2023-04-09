package Algorithm_Carl.DynamicProgramming;

import java.util.Arrays;

public class BestTeamWithNoConflicts {
  public int bestTeamScore(int[] scores, int[] ages) {
    int n = scores.length;
    int[][] arr = new int[n][2];

    for (int i = 0; i < n; ++i) {
      arr[i][0] = ages[i];
      arr[i][1] = scores[i];
    }

    Arrays.sort(arr, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
    // System.out.println(Arrays.deepToString(arr));

    // dp[i] for max score when the last player is i
    int[] dp = new int[n];
    int res = 0;

    for (int i = 0; i < n; ++i) {
      int max = 0;
      for (int j = 0; j < i; ++j) {
        if (arr[j][1] <= arr[i][1]) {
          max = Math.max(max, dp[j]);
        }
      }
      dp[i] = arr[i][1] + max;
      res = Math.max(res, dp[i]);
    }

    return res;
  }
}
