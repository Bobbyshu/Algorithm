package A_OUEI.DaiMaXingHao.zip;

import java.util.HashMap;
import java.util.Map;

public class InventorySystem {
    //    return int
    int solution(String[] pricelist, String[] logs) {
        int res = 0;

        Map<String, Integer> map = new HashMap<>();
        for (String s : pricelist) {
            int divide = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ':') {
                    divide = i;
                }
                map.put(s.substring(0, i), Integer.valueOf(s.substring(i + 2, s.length())));
            }
        }


        for (String s : logs) {
            String[] arr = s.split(" ");
            if (arr[0].equals("discount_start")) {
                map.put(arr[1].substring(0, arr[1].length() - 1), Integer.valueOf(arr[3]));
            }
        }

        return 0;
    }
}
