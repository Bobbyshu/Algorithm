package Leetcode.weeklycontest.Normal.NO341;

public class t2 {
  public int maxDivScore(int[] nums, int[] divisors) {
    int n = divisors.length;
    int[] res = new int[n];
    for (int i = 0; i < n; ++i) {
      int cnt = 0;
      for (int num : nums) {
        if (num % divisors[i] == 0) {
          ++cnt;
        }
      }
      res[i] = cnt;
    }

    int max = 0, maxIdx = 0;
    for (int i = 0; i < n; ++i) {
      if (res[i] > max) {
        max = res[i];
        maxIdx = i;
      } else if (res[i] == max && divisors[i] < divisors[maxIdx]) {
        maxIdx = i;
      }
    }

    return divisors[maxIdx];
  }
}
