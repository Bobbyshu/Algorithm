package Leetcode.weeklycontest.DOUBLE.NO133;

public class t2 {
  // 如果 nums[0]=1，无需修改，问题变成剩下 n−1 个数如何操作。接下来考虑 nums[1]
  //如果 nums[0]=0，修改，问题变成剩下 n−1 个数如何操作。接下来考虑 nums[1]
  public int minOperations(int[] nums) {
    int n = nums.length, res = 0;
    for (int i = 0; i < n - 2; i++) {
      if (nums[i] == 1) {
        continue;
      }

      nums[i] = reverse(nums[i]);
      nums[i + 1] = reverse(nums[i + 1]);
      nums[i + 2] = reverse(nums[i + 2]);
      ++res;
    }

    // System.out.println(Arrays.toString(nums));

    for (int num : nums) {
      if (num == 0) {
        return -1;
      }
    }

    return res;
  }

  private int reverse(int i) {
    return i == 0 ? 1 : 0;
  }
}
