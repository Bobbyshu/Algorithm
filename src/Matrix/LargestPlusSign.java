package Matrix;

import java.util.Arrays;

public class LargestPlusSign {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] grid = new int[n][n];
        for (int[] mine : grid) {
            Arrays.fill(mine, 1);
        }

        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }

        return 1;
    }
}
