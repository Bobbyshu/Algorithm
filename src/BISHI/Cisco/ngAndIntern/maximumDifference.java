package BISHI.Cisco.ngAndIntern;

public class maximumDifference {
    int max(int[] arr) {
        int n = arr.length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                res = Math.max(res, arr[j] - arr[i]);
            }
        }
        return res;
    }
}
