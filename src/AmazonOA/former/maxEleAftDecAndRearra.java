package AmazonOA.former;

import java.util.Arrays;

public class maxEleAftDecAndRearra {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return 1;

        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i - 1] > 1) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[n - 1];
    }
}
