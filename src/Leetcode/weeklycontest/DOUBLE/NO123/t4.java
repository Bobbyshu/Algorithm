package Leetcode.weeklycontest.DOUBLE.NO123;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class t4 {
    public static void main(String[] args) {
        int[][] p = {{6, 2}, {4, 4}, {2, 6}};
        t4 ttt = new t4();
        int num = ttt.check(p, 2, 0);
        System.out.println(num);
    }

    public int Optimize(int[][] points) {
        // 限定了坐标轴是往右边滑的，合法的点只能是变扁的长方形，且往右上角去化
        Arrays.sort(points, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1]);

        int res = 0;
        for (int i = 0; i < points.length; ++i) {
            int a_y = points[i][1];
            int maxY = Integer.MIN_VALUE;
            for (int j = i + 1; j < points.length; ++j) {
                int b_y = points[j][1];
                if (b_y <= a_y && b_y > maxY) {
                    maxY = b_y;
                    ++res;
                }
            }
        }
        return res;
    }

    public int numberOfPairs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; ++i) {
            for (int j = i + 1; j < points.length; ++j) {
                res += check(points, i, j);
                res += check(points, j, i);
            }
        }
        return res;
    }

    private int check(int[][] points, int a, int b) {
        // same row
        if (points[a][0] > points[b][0] || points[a][1] < points[b][1]) {
            return 0;
        }

        Set<String> set = new HashSet<>();
        for (int i = points[a][0]; i <= points[b][0]; ++i) {
            for (int j = points[a][1]; j >= points[b][1]; --j) {
                set.add(i + " + " + j);
            }
        }

        set.remove(points[a][0] + " + " + points[a][1]);
        set.remove(points[b][0] + " + " + points[b][1]);

//        for (int[] p : set) {
//            System.out.println(Arrays.toString(p));
//        }

        for (int[] p : points) {
            if (set.contains(p[0] + " + " + p[1])) {
                return 0;
            }
        }

        return 1;
    }


}
