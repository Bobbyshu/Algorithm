package A_OUEI.AIKeSiPiDia_OUEI;

import java.util.Arrays;

public class Maximum_Score {
    int maximumScore(int[] arr, int k) {
        Arrays.sort(arr);
        int sum = 0;
        int n = arr.length;
        for (int i = n - 1; i >= n - k; i--) {
            sum += arr[i];
        }
        return sum;
    }
}
