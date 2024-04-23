package Leetcode.weeklycontest.Normal.NO394;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class t3 {
   // dp table find all available options
    // [4,5,0,1]
    // [1,9,0,8]
    // [2,2,5,3]
    // [2,0,9,3]
    public int minimumOperations(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[n][10];
        // preprocess
        // O(m * n * k)
        for (int j = 0; j < n; ++j) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] g : grid) {
                map.merge(g[j], 1, Integer::sum);
            }

            for (int i = 0; i < 10; ++i) {
                int time = map.getOrDefault(i, 0);
                dp[j][i] = m - time;
            }
        }
        // System.out.println(Arrays.deepToString(dp));

        // [4,5,0,1]
        // [1,9,0,8]
        // [2,2,5,3]
        // [2,0,9,3]
        // [4,5,0,1]
        // [3,9,0,8]
        // [2,2,5,3]
        // [4,0,9,3]
        int[][] table = new int[n][10];
        for (int[] r : table) {
            Arrays.fill(r, (int) 1e9);
        }
        for (int k = 0; k < 10; ++k) {
            table[0][k] = dp[0][k];
        }

        // O(n * k^2)
        for (int j = 1; j < n; ++j) {
            for (int k = 0; k < 10; ++k) {
                for (int l = 0; l < 10; ++l) {
                    if (l != k) {
                        table[j][k] = Math.min(table[j][k], table[j - 1][l] + dp[j][k]);
                    }
                }
            }
        }
        // System.out.println(Arrays.deepToString(table));


        int res = Integer.MAX_VALUE;
        for (int k = 0; k < 10; ++k) {
            res = Math.min(res, table[n - 1][k]);
        }


        return res;
    }
}
