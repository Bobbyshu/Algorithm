package BISHI.Cisco;

import java.util.HashMap;
import java.util.Map;

public class birthdayCount {
    public static int findDay(int[] arr){
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
        }

        for (Integer key : map.keySet()) {
            int result = map.get(key);
            if (result % 2 == 1) res++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4,8,2,8,9};

        System.out.println(findDay(arr));
    }
}
