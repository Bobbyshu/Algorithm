package Leetcode.weeklycontest.Normal.NO385;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class t3 {

    public static void main(String[] args) {
        t3 t3 = new t3();
        int[][] mat = new int[][]{{9,3,8},{4,2,5},{3,8,6}};
        t3.mostFrequentPrime(mat);
    }
    Map<Integer, Integer> map;
    int m, n;
    boolean[] isPrime;
    public int mostFrequentPrime(int[][] mat) {
        map = new HashMap<>();
        this.m = mat.length;
        this.n = mat[0].length;
        int num = 1;
        for (int i = 0; i < Math.max(m, n); ++i) {
            num *= 10;
        }
        this.isPrime = getPrime(num);

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                collect(mat, i, j);
            }
        }
//        System.out.println(map);

        int max = 0, res = -1;
        for (int i : map.values()) {
            max = Math.max(max, i);
        }


        for (int k : map.keySet()) {
            if (map.get(k) == max) {
                res = Math.max(res, k);
            }
        }

        return res;
    }

    private void collect(int[][] mat, int startI, int startJ) {
        int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, 1}, {-1, -1}, {1, -1}};

        int idx = 0;
        while (idx < 8) {
            int[] move = dir[idx];
            int i = startI, j = startJ;
            int cur = mat[i][j];

            while (true) {
                if (cur > 10 && isPrime[cur]) {
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                }
                i += move[0];
                j += move[1];
                if (i < 0 || j < 0 || i >= m || j >= n) {
                    break;
                }
                cur = cur * 10 + mat[i][j];
            }

            ++idx;
        }
    }

    private boolean[] getPrime(int num) {
        boolean[] isPrime = new boolean[num + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < num; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < num; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}
