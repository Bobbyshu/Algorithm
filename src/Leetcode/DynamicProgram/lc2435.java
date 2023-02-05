package Leetcode.DynamicProgram;
/*
动态规划，状态是增加的，只能由左边或者上边过来，
每次过来其实是枚举余数，(grid[i][j]+p)%k + grid[i][j -1][p]；
 */
public class lc2435 {
    public static void main(String[] args) {
        int[][] grid = {{5, 2, 4}, {3, 0, 5}, {0, 7, 2}};
        int k = 3;
        numberOfPaths(grid, k);
    }

    static int numberOfPaths(int[][] grid, int k) {
        int mod = 1000000007;
        int m = grid.length, n = grid[0].length;
        long[][][] dp = new long[m][n][k];
        dp[0][0][grid[0][0] % k] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int p = 0; p < k; p++) {
                    if (i > 0) {
                        dp[i][j][(grid[i][j] + p) % k] = (dp[i][j][(grid[i][j] + p) % k] + dp[i - 1][j][p]) % mod;
                    }

                    if (j > 0) {
                        dp[i][j][(grid[i][j] + p) % k] = (dp[i][j][(grid[i][j] + p) % k] + dp[i][j - 1][p]) % mod;
                    }
                }
            }
        }

        return (int) dp[m - 1][n - 1][0];
    }
}
