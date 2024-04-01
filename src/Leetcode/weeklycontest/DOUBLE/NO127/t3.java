package Leetcode.weeklycontest.DOUBLE.NO127;

public class t3 {

  public static void main(String[] args) {
    int[] nums = {1,2,3};
    minimumSubarrayLength(nums, 2);
  }
  public static int minimumSubarrayLength(int[] nums, int k) {
    int n = nums.length;
    int[] bit = new int[32];
    int res = Integer.MAX_VALUE, cur = 0;

    int l = 0, r = 0;
    while (r < n) {
      cur |= nums[r];

      for (int i = 0; i < 32; ++i) {
        // check each bit has one or not
        if ((nums[r] & (1 << i)) != 0) {
          ++bit[i];
        }
      }

      while (cur >= k && l <= r) {
        // equals to reverse the |=
        //
        res = Math.min(res, r - l + 1);
        for (int i = 0; i < 32; ++i) {
          if ((nums[l] & (1 << i)) != 0) {
            --bit[i];
            if (bit[i] == 0) {
              cur -= (1 << i);
            }
          }
        }
        ++l;
      }

      ++r;
    }

    return res == Integer.MAX_VALUE ? -1 : res;
  }
}
