package Leetcode.weeklycontest.Normal.NO388;

import java.util.Arrays;

public class t2 {
  public long maximumHappinessSum(int[] happiness, int k) {
    Arrays.sort(happiness);
    int n = happiness.length;
    long ans = 0;
    for (int i = n - 1; i >= n - k && happiness[i] > n - 1 - i; i--) {
      ans += happiness[i] - (n - 1 - i);
    }
    return ans;
  }
}
