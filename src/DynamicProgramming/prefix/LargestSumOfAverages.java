package DynamicProgramming.prefix;
//枚举 + 前缀和 + 动态规划
public class LargestSumOfAverages {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;

        double[] prefix = new double[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + (double) nums[i - 1];
        }

        double[][] dp = new double[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            //if only split into 1 group, just use the sum / quantity is ok
            dp[i][1] = prefix[i] / i;
            //traverse the group, the ceiling is
            // k (Maximum available group) Or
            // i (Maximum usable numbers
            for (int j = 2; j <= Math.min(k, i); j++) {
                // traverse the split location and register the best solution
                for (int m = 1; m < i; m++) {
                    //choose the best before or choose the best location to spilt
                    dp[i][j] = Math.max(dp[i][j], dp[m][j - 1] + (prefix[i] - prefix[m]) / (i - m));
                }
            }
        }

        return dp[n][k];
    }
}
