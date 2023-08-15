package BISHI.Codesignal.databricks;

import java.util.Arrays;

public class Scooter {
    public static void main(String[] args) {
        int[] arr1 = {7, 4, 14};
        int[] arr2 = {15, 7, 3, 10};

        System.out.println(walkDistance(arr1,24));
        System.out.println(walkDistance(arr2, 27));
    }

    // finish <= 1000
    public static int walkDistance(int[] scooter, int target) {
        Arrays.sort(scooter);
        int cur = scooter[0], res = scooter[0], n = scooter.length;
        for (int i = 1; i < n; ++i) {
            if (cur + 10 >= target) {
                return res;
            }
            if (scooter[i] >= cur + 10) {
                res += scooter[i] - cur - 10;
            }
            cur = scooter[i];
        }

        return scooter[n - 1] + 10 >= target ? res : res + target - (scooter[n - 1] + 10);
    }
}
