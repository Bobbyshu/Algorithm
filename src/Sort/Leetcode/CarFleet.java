package Sort.Leetcode;

import java.util.Arrays;

public class CarFleet {
    public static void main(String[] args) {
        int[] p = {10, 8, 0, 5, 3};
        int[] s = {2, 4, 1, 1, 3};
        carFleet(12, p, s);
    }

    static public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 1)
            return 1;

        double[][] cars = new double[n][2];
        for (int i = 0; i < n; ++i) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }

        Arrays.sort(cars, (a, b) -> (int) (a[0] - b[0]));
//        System.out.println(cars[3][1]);

        int res = 0;
        for (int i = n - 1; i >= 1; --i) {
            if (cars[i][1] < cars[i - 1][1]) {
                ++res;
            } else {
                cars[i - 1] = cars[i];
            }
        }

        return ++res;
    }
}
