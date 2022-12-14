package A_OUEI.Cisco.ngAndIntern;

public class jarsOfChocolates {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int l = nums.length;
        int[] dp = new int[l + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= l; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
        }
        return dp[l];
    }
}
