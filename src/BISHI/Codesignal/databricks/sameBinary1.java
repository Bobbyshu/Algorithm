package BISHI.Codesignal.databricks;

import java.util.HashMap;
import java.util.Map;

public class sameBinary1 {
    public static void main(String[] args) {
        int[] a = {3, 5, 10, 6, 2, 8};
        int[] b = {3, 5, 1, 7, 8, 10, 62, 13};
        int count = countPairsWithSameBinaryOnes(a);
        int count2 = countPairsWithSameBinaryOnes(b);
        System.out.println("Number of pairs with same number of binary ones: " + count2);
    }

    public static int countPairsWithSameBinaryOnes(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0, n = a.length;

        for (int i = 0; i < n; i++) {
            int one = cal(a[i]);

            if (map.containsKey(one)) {
                cnt += map.get(one);
            }

            map.put(one, map.getOrDefault(one, 0) + 1);
        }

        return cnt;
    }

    public static int cal(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num >>= 1;
        }
        return count;
    }


}
