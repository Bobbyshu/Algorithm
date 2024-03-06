package Leetcode.weeklycontest.Normal.NO387;

public class t2 {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] preSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i - 1][j]
                        + preSum[i][j - 1]
                        - preSum[i - 1][j - 1]
                        + grid[i - 1][j - 1];
            }
        }
        // System.out.println(Arrays.deepToString(preSum));

        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int cur = sumRegion(preSum, 0, 0, i, j);
                if (cur <= k) {
                    ++res;
                }
            }
        }

        return res;
    }

    private int sumRegion(int[][] preSum, int x1, int y1, int x2, int y2) {
        return preSum[x2 + 1][y2 + 1]
                - preSum[x1][y2 + 1]
                - preSum[x2 + 1][y1]
                + preSum[x1][y1];
    }
}
