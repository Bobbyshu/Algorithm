package A_OUEI.DaiMaXingHao.ebay;

import java.util.Arrays;

public class computeBlackCount {
    public static void main(String[] args) {
        int[][] black = {{0, 0}, {0, 1}, {1, 0}};
        compute(3, 3, black);
        System.out.println(Arrays.toString(compute(3, 3, black)));
    }

    static int[] compute(int rows, int cols, int[][] black) {
        int[][] grid = new int[rows][cols];
        for (int[] b : black) {
            int i = b[0], j = b[1];
            grid[i][j] = 1;
        }

        int[] res = new int[5];
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                int count = grid[i][j] + grid[i + 1][j + 1] + grid[i + 1][j] + grid[i][j + 1];
                res[count]++;
            }
        }

        return res;
    }
}
