package A_OUEI.sike.ngAndIntern;

import java.util.Arrays;

public class rowMaxColumnMin {
    int rowMaxColumnMin(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] maxRow = new int[m][n], minCol = new int[m][n];
        for (int i = 0; i < m; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                max = Math.max(matrix[i][j], max);
            }
            Arrays.fill(maxRow[i], max);
        }

        for (int j = 0; j < n; j++) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                min = Math.min(matrix[i][j], min);
            }
            for (int k = 0; k < m; k++) {
                minCol[k][j] = min;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == maxRow[i][j] && maxRow[i][j] == minCol[i][j]) {
                    return matrix[i][j];
                }
            }
        }

        return -1;
    }

    
}
