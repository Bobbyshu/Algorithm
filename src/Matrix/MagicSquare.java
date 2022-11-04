package Matrix;

import java.util.HashSet;
import java.util.Set;

public class MagicSquare {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int r = 0; r < m - 2; r++) {
            for (int c = 0; c < n - 2; c++) {
                if (grid[r + 1][c + 1] != 5)
                    continue;

                if (magic(grid[r][c], grid[r][c+1], grid[r][c+2],
                        grid[r+1][c], grid[r+1][c+1], grid[r+1][c+2],
                        grid[r+2][c], grid[r+2][c+1], grid[r+2][c+2]))
                    res++;
            }
        }

        return res;
    }

    boolean magic(int... vals) {
        int[] count = new int[16];
        for (int v : vals) {
            if (v == 0 || v >= 10)
                return false;
            count[v]++;
        }
        for (int v = 1; v <= 9; v++) {
            if (count[v] != 1) {
                return false;
            }
        }
        return (vals[0] + vals[1] + vals[2] == 15 &&
                vals[3] + vals[4] + vals[5] == 15 &&
                vals[6] + vals[7] + vals[8] == 15 &&
                vals[0] + vals[3] + vals[6] == 15 &&
                vals[1] + vals[4] + vals[7] == 15 &&
                vals[2] + vals[5] + vals[8] == 15 &&
                vals[0] + vals[4] + vals[8] == 15 &&
                vals[2] + vals[4] + vals[6] == 15);
    }
}
