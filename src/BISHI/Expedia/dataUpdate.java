package BISHI.Expedia;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class dataUpdate {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int[][] arr2 = {{1, 2}, {2, 3}};
        dataUpdate cf = new dataUpdate();
        System.out.println(Arrays.toString(cf.arr1(arr, arr2)));
    }
    int[] arr1(int[] arr, int[][] range) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = range[0].length;
        for (int[] ints : range) {
            for (int j = 0; j < n; j++) {
                map.put(ints[j], map.getOrDefault(ints[j], 0) + 1);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) % 2 != 0) {
                arr[i] = -arr[i];
            }
        }

        return arr;
    }
}
