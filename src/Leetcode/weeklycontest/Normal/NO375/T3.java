package Leetcode.weeklycontest.Normal.NO375;

public class T3 {
  public long countSubarrays(int[] nums, int k) {
    int max = 0;
    for (int n : nums) {
      max = Math.max(max, n);
    }

    long res = 0L;
    int cnt = 0, l = 0, r = 0, n = nums.length;

    while (r < n) {
      if (nums[r++] == max) {
        ++cnt;
      }

      while (cnt == k) {
        if (nums[l++] == max) {
          --cnt;
        }
      }

      // added all subarray
      res += l;
    }

    return res;
  }
}
