package String.SubArray;

import java.util.ArrayList;
import java.util.List;

public class getSubArray {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> path = new ArrayList<>();
            for (int j = i; j < n; j++) {
                path.add(arr[j]);
                res.add(new ArrayList<>(path));
            }
        }

        System.out.println(res);
    }
}
