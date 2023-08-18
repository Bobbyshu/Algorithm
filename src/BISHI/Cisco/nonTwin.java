package BISHI.Cisco;

import java.util.HashMap;
import java.util.Map;

public class nonTwin {
    int nonTwin(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = Integer.MAX_VALUE;
        for (int num : map.keySet()) {
            if (map.get(num) < 2) {
                res = Math.min(res, num);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
