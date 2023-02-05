package Leetcode.weeklycontest.DOUBLE.NO97;

public class t3 {
  public static void main(String[] args) {
    int[] p = {1,1,2,2,3,3,5};
    maximizeWin(p, 2);
  }
  public static int maximizeWin(int[] prizePositions, int k) {
    int n = prizePositions.length;
    int res = 0, i = 0;
    int[] cnt = new int[n + 1];

    for (int j = 0; j < n; ++j) {
      while (prizePositions[j] - prizePositions[i] > k) {
        ++i;
      }
      res = Math.max(res, j - i + 1 + cnt[i]);
      cnt[j + 1] = Math.max(cnt[j], j - i + 1);
    }
    return res;
  }
}
