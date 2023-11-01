package Leetcode.weeklycontest.Normal.NO367;

public class t3 {
  public int[] findIndices(int[] nums, int idx, int val) {
    int n = nums.length;
    int[][] max = new int[n][2];
    int[][] min = new int[n][2];

    max[0][0] = nums[0];
    max[0][1] = 0;
    min[0][0] = nums[0];
    min[0][1] = 0;

    for (int i = 1; i < n; ++i) {
      if (nums[i] > max[i - 1][0]) {
        max[i][0] = nums[i];
        max[i][1] = i;
      } else {
        max[i][0] = max[i - 1][0];
        max[i][1] = max[i - 1][1];
      }

      if (nums[i] < min[i - 1][0]) {
        min[i][0] = nums[i];
        min[i][1] = i;
      } else {
        min[i][0] = min[i - 1][0];
        min[i][1] = min[i - 1][1];
      }
    }

    for (int i = idx; i < n; ++i) {
      int cur = Math.max(Math.abs(nums[i] - max[i - idx][0]),
          Math.abs(nums[i] - min[i - idx][0]));
      if (cur >= val) {
        if (Math.abs(nums[i] - max[i - idx][0]) > Math.abs(nums[i] - min[i - idx][0])) {
          return new int[]{i, max[i - idx][1]};
        } else {
          return new int[]{i, min[i - idx][1]};
        }
      }
    }

    return new int[]{-1, -1};
  }
}
