package Leetcode.weeklycontest.DOUBLE.NO127;

public class t2 {
  public int minimumLevels(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n; ++i) {
      if (nums[i] == 0) {
        nums[i] = -1;
      }
    }

    int[] prefix = new int[n], suffix = new int[n];
    prefix[0] = nums[0];
    for (int i = 1; i < n; ++i) {
      prefix[i] = prefix[i - 1] + nums[i];
    }

    suffix[n - 1] = nums[n - 1];
    for (int i = n - 2; i >= 0; --i) {
      suffix[i] = suffix[i + 1] + nums[i];
    }

    // 1 -1 1 -1
    // 1 0 1 0
    // 0 -1 0 -1
    // System.out.println(Arrays.toString(prefix));
    // System.out.println(Arrays.toString(suffix));

    for (int i = 0; i < n - 1; ++i) {
      if (prefix[i] > suffix[i + 1]) {
        return i + 1;
      }
    }

    return -1;
  }
}
