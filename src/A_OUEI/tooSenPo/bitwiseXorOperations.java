package A_OUEI.tooSenPo;

import java.util.Arrays;

public class bitwiseXorOperations {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8};
        int[] arr2 = {5, 6, 7, 8};
        System.out.println(Arrays.toString(bitOperations(arr, 4)));

        System.out.println(Arrays.toString(bitOper(arr2, 4)));
    }

    static int[] bitOperations(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < k; i++) {
            arr[i % n] ^= arr[n - (i % n) - 1];
        }
        return arr;
    }

    static int[] bitOper(int[] arr, int k) {
        int[] ori = Arrays.copyOf(arr, arr.length);
        int n = arr.length;
        if (k % 2 == 0) {
            for (int i = 0; i < k; i++) {
                if (i < k / 2) {
                    arr[i % n] ^= arr[n - (i % n) - 1];
                } else {
                    arr[i % n] = ori[n - (i % n) - 1];
                }
            }
        } else {
            for (int i = 0; i < k; i++) {
                if (i <= k / 2) {
                    arr[i % n] ^= arr[n - (i % n) - 1];
                } else {
                    arr[i % n] = ori[n - (i % n) - 1];
                }
            }
        }
        return arr;
    }
}
