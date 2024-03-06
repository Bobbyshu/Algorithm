package Leetcode.weeklycontest.Normal.NO387;

public class t3 {
    // check y element freq
    // check other element freq
    public int minimumOperationsToWriteY(int[][] grid) {
        int[] freqY = new int[3];
        int[] freqO = new int[3];
        int n = grid.length;
        int m = n / 2;

        for (int i = 0; i < m; i++) {
            freqY[grid[i][i]]++;
            freqY[grid[i][n - 1 - i]]++;
            for (int j = 0; j < n; j++) {
                if (j != i && j != n - 1 - i) {
                    freqO[grid[i][j]]++;
                }
            }
        }
        for (int i = m; i < n; i++) {
            freqY[grid[i][m]]++;
            for (int j = 0; j < n; j++) {
                if (j != m) {
                    freqO[grid[i][j]]++;
                }
            }
        }

        // find the maximum unnecessary change number
        int res = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    res = Math.max(res, freqY[i] + freqO[j]);
                }
            }
        }
        return n * n - res;
    }
}
