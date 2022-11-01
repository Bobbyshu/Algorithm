package DynamicProgramming;

import java.util.Arrays;

public class lc1220 {
    int MOD = (int) 1e9 + 7;

    public int countVowelPermutation(int n) {
        long[][] f = new long[n][5];
        Arrays.fill(f[0], 1);

        for (int i = 1; i < n; i++) {
            f[i][0] = f[i - 1][1];
            f[i][1] = f[i - 1][0] + f[i - 1][2];
            f[i][2] = f[i - 1][0] + f[i - 1][1] + f[i - 1][3] + f[i - 1][4];
            f[i][3] = f[i - 1][2] + f[i - 1][4];
            f[i][4] = f[i - 1][0];

            for (int j = 0; j < 5; j++) {
                f[i][j] %= MOD;
            }
        }

        long ans = 0;
        for (int i = 0; i < 5; i++) {
            ans += f[n - 1][i];
        }

        return (int) (ans % MOD);
    }
}
