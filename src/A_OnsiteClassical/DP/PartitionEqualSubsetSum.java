package A_OnsiteClassical.DP;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
  public static void main(String[] args) {
    int[] arr = {23,13,11,7,6,5,5};
    canPartition(arr);
  }
  public boolean canPartition(int[] nums) {
    Arrays.sort(nums);
    int sum = 0;

    for (int i : nums) {
      sum += i;
    }

    // System.out.println(sum);

    if (sum % 2 != 0) {
      return false;
    }

    boolean[] dp = new boolean[sum / 2 + 1];
    dp[0] = true;

    for (int i = 0; i < nums.length; ++i) {
      for (int j = sum / 2; j >= nums[i]; --j) {
        // here we can't just use = because when we meet with
        // larger number, it may change dp[j] from true to false
        // cuz it can start from non-reach false directly
        dp[j] |= dp[j - nums[i]];
      }
    }

    // System.out.println(Arrays.toString(dp));


    return dp[sum / 2];
  }
}
