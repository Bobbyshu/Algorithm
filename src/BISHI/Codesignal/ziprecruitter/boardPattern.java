package BISHI.Codesignal.ziprecruitter;

public class boardPattern {
    int[] boardPattern(int[][] matrix, int[][] pattern) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (matrix[i][j] != pattern[0][0]) {
                    continue;
                } else {

                }
            }
        }

        return new int[]{-1, -1};
    }
}
