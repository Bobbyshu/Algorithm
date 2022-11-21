package DynamicProgramming.State;
/*
lc926
当前字符串为1的话，下一个只能是1，当前为0的话，就可1可0。
 */
public class FlipStringToMonotoneIncreasing {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        if (n == 1) {
            return 0;
        }

        int[][] dp = new int[n + 1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        for (int i = 0; i < n; i++) {
            dp[i + 1][0] = dp[i][0] + (s.charAt(i) == '1' ? 1 : 0);
            dp[i + 1][1] = Math.min(dp[i][0], dp[i][1]) + (s.charAt(i) == '0' ? 1 : 0);
        }

        return Math.min(dp[n][0], dp[n][1]);
    }
}
