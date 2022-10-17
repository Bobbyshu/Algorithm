package A_OUEI.tooSenPo;

import java.util.Arrays;

public class simpleMatrixSummation {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        System.out.println((Arrays.deepToString(prefix(a))));
    }

    static int[][] prefix(int[][] a) {
        int m = a.length, n = a[0].length;
        int[][] b = new int[m][n];
        b[0][0] = a[0][0];

        for (int i = 1; i < m; i++) {
            b[i][0] = b[i - 1][0] + a[i][0];
        }

        for (int j = 1; j < n; j++) {
            b[0][j] = b[0][j - 1] + a[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                b[i][j] = b[i - 1][j] + b[i][j - 1] - b[i - 1][j - 1] + a[i][j];
            }
        }

        return b;
    }
}
