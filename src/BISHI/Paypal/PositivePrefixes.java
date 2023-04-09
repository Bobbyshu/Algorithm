package BISHI.Paypal;

import java.util.Arrays;

public class PositivePrefixes {
    int positive(int[] arr) {
        long sum = 0L;
        Arrays.sort(arr);
        reverse(arr);
        int res = 0;
        for (int num : arr) {
            sum += num;
            if (sum > 0) {
                res++;
            } else {
                break;
            }
        }
        return res;
    }

    void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
