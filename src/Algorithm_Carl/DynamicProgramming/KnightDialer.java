package Algorithm_Carl.DynamicProgramming;

public class KnightDialer {
    int[][] dir = {{4, 6}, {6, 8}, {7, 9}, {4, 8},
            {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
    int mod = (int) 1e9 + 7;
    int[][] memo;

    public int knightDialer(int n) {
        if (n == 1) {
            return 10;
        }

        long[][] dp = new long[n + 1][10];
        for (int j = 0; j < 10; ++j) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j < 10; ++j) {
                for (int pre : dir[j]) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][pre]) % mod;
                }
            }
        }

        long sum = 0L;
        for (int j = 0; j < 10; ++j) {
            sum = (sum + dp[n][j]) % mod;
        }

        return (int) sum;
    }

    public int knightDialerMemoryRecursion(int n) {
        memo = new int[n][10];
        int res = 0;
        for (int i = 0; i < 10; ++i) {
            res = (res + dp(n - 1, i)) % mod;
        }
        return res;
    }

    int dp(int n, int i) {
        if (n == 0) {
            return 1;
        }

        if (memo[n][i] != 0) {
            return memo[n][i];
        }

        int res = 0;
        for (int neighbor : dir[i]) {
            res = (res + dp(n - 1, neighbor)) % mod;
        }

        memo[n][i] = res;
        return res;
    }
}
