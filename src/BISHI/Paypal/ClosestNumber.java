package BISHI.Paypal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestNumber {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length, min = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            min = Math.min(min, arr[i + 1] - arr[i]);
        }

        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] - arr[i] == min) {
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }

        System.out.println(res);
        return res;
    }
}

