package A_OnsiteClassical.Tiktok;

import java.util.Arrays;
import java.util.List;

public class LongestSubsequenceSumTarget {
  public int lengthOfLongestSubsequence(List<Integer> nums, int target) {

    int[] dp = new int[target + 1];
    Arrays.fill(dp, Integer.MIN_VALUE);
    dp[0] = 0;

    for (int i = 0; i < nums.size(); ++i) {
      for (int j = target; j >= nums.get(i); --j) {
        if (dp[j - nums.get(i)] != Integer.MIN_VALUE) {
          dp[j] = Math.max(dp[j], dp[j - nums.get(i)] + 1);
        }
      }
    }

    return dp[target] == Integer.MIN_VALUE ? -1 : dp[target];
  }
}
