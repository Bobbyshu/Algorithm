package Leetcode.weeklycontest.Normal.NO340;

import java.util.Arrays;

public class t1 {
  public int diagonalPrime(int[][] nums) {
    int n = 4000001;
    boolean[] isPrime = new boolean[n];
    Arrays.fill(isPrime, true);
    // 从 2 开始枚举到 sqrt(n)。
    for (int i = 2; i * i < n; i++) {
      // 如果当前是素数
      if (isPrime[i]) {
        // 就把从 i*i 开始，i 的所有倍数都设置为 false。
        for (int j = i * i; j < n; j += i) {
          isPrime[j] = false;
        }
      }
    }
    // important
    isPrime[1] = false;

    int len = nums.length, res = 0;
    for (int i = 0; i < len; ++i) {
      int first = nums[i][i];
      int second = nums[i][len - i - 1];
      if (isPrime[first]) {
        res = Math.max(res, first);
      }
      if (isPrime[second]) {
        res = Math.max(res, second);
      }
    }

    return res;
  }
}
