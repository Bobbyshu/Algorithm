package AmazonOA.recently;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinimumTotalLag {
    int min(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int sum = 0;

        for (int i = 0; i < arr1.length; i++) {
            sum += Math.abs(arr1[i] - arr2[i]);
        }

        return sum;
    }
}
