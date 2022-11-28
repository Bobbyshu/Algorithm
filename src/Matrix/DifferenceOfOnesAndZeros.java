package Matrix;

public class DifferenceOfOnesAndZeros {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int sum = m + n;
        int[][] res = new int[m][n];

        int[] zeroRow = new int[m];
        int[] zeroCol = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    zeroRow[i]++;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            for (int[] g : grid) {
                if (g[j] == 0) {
                    zeroCol[j]++;
                }
            }
        }

        // System.out.println(Arrays.toString(zeroCol));
        // System.out.println(Arrays.toString(zeroRow));

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = sum - 2 * (zeroRow[i] + zeroCol[j]);
            }
        }

        return res;
    }
}
