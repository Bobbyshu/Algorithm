package Leetcode.weeklycontest.Normal.NO339;

import java.util.Arrays;

public class t3 {
  public int miceAndCheese(int[] reward1, int[] reward2, int k) {
    int n = reward1.length;
    int[][] diff = new int[n][2];
    for (int i = 0; i < n; i++) {
      diff[i][0] = reward1[i] - reward2[i];
      diff[i][1] = i;
    }
    Arrays.sort(diff, (a, b) -> b[0] - a[0]);

    int ans = 0;
    for (int i = 0; i < k; i++) {
      ans += reward1[diff[i][1]];
    }
    for (int i = k; i < n; i++) {
      ans += reward2[diff[i][1]];
    }
    return ans;
  }
}
