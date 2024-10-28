package A_OnsiteClassical.Tiktok;

public class NO300_LongestIncreasingSubsequence {
  public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];

    int res = 0;
    for (int num : nums) {
      int l = 0, r = res;

      while (l < r) {
        int mid = (l + r) / 2;
        if (dp[mid] < num) {
          l = mid + 1;
        } else {
          r = mid;
        }
      }

      dp[l] = num;
      if (res == r) {
        ++res;
      }
    }

    return res;
  }
}
