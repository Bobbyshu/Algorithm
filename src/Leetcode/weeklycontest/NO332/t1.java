package Leetcode.weeklycontest.NO332;

public class t1 {
  public long findTheArrayConcVal(int[] nums) {
    int i = 0, j = nums.length - 1;
    long res = 0L;
    while (i < j) {
      String s1 = nums[i] + "";
      String s2 = nums[j] + "";
      String s3 = s1 + s2;

      res += (long) Long.parseLong(s3);
      ++i;
      --j;
    }

    return res + nums[i];
  }
}
