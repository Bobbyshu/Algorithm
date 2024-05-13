package Leetcode.weeklycontest.Normal.NO397;

public class T2 {
  public static void main(String[] args) {
    int[] a = {5, 2, -10, -5, 1};
    maximumEnergy(a, 3);
  }

  public static int maximumEnergy(int[] energy, int k) {
    int n = energy.length;
    int[] dp = new int[n];

    int res = Integer.MIN_VALUE;
    for (int i = 0; i < n; ++i) {
      dp[i] = energy[i];
      if (i < k) {
        dp[i] = energy[i];
      } else {
        dp[i] = Math.max(dp[i - k] + energy[i], energy[i]);
      }
      if (i + k >= n) {
        res = Math.max(res, dp[i]);
      }
    }

    return res;
  }

  public int reverseCount(int[] energy, int k) {
    int len = energy.length;
    int res = energy[len - 1];
    for (int i = 0; i < k; i++) { //起点最多k个
      int st = 0;
      //从后往前跳
      for (int j = len - 1 - i; j >= 0; j = j - k) {
        st = st + energy[j];
        res = Math.max(res, st); //记录过程中最大的累加值。
      }
    }
    return res;
  }

}
