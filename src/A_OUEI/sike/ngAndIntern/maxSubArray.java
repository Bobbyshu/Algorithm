package A_OUEI.sike.ngAndIntern;

public class maxSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        int res = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
