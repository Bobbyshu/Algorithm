package Leetcode.weeklycontest.Normal.NO342;

public class t4 {
  class Solution {
    public int minOperations(int[] nums) {
      int n = nums.length;
      int cnt = 0;
      for (int i = 0; i < n; i++) {
        if (nums[i] == 1) {
          cnt++;
        }
      }

      if (cnt > 0) {
        return n - cnt;
      }

      int res = Integer.MAX_VALUE;
      for (int i = 0; i < n; i++) {
        int num = nums[i];
        for (int j = i + 1; j < n; j++) {
          num = gcd(num, nums[j]);
          if (num == 1) {
            res = Math.min(res, j - i);
            break;
          }
        }
        if (num != 1) {
          break;
        }
      }
      if (res == Integer.MAX_VALUE) {
        return -1;
      }
      return n - 1 + res;
    }

    public int gcd(int a, int b) {
      if (a == 0) {
        return b;
      }
      return gcd(b % a, a);
    }
  }
}
