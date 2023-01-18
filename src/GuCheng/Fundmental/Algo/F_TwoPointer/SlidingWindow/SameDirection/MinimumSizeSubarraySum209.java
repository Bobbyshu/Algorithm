package GuCheng.Fundmental.Algo.F_TwoPointer.SlidingWindow.SameDirection;

public class MinimumSizeSubarraySum209 {
  public int minSubArrayLen(int target, int[] nums) {
    int n = nums.length, sum = 0, left = 0, res = Integer.MAX_VALUE;
    for (int right = 0; right < n; ++right) {
      sum += nums[right];
      while (sum >= target) {
        res = Math.min(res, right - left + 1);
        sum -= nums[left];
        ++left;
      }
    }
    return res == Integer.MAX_VALUE ? 0 : res;
  }

  public int minSubArrayLen2(int target, int[] nums) {
    int i = 0, j = 0, sum = 0, res = Integer.MAX_VALUE;
    while (j < nums.length) {
      sum += nums[j];
      while (sum >= target) {
        res = Math.min(res, j - i + 1);
        sum -= nums[i];
        ++i;
      }
      ++j;
    }

    return res == Integer.MAX_VALUE ? 0 : res;
  }
}
