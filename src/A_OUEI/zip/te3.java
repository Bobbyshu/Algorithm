package A_OUEI.zip;

import java.util.HashMap;
import java.util.Map;

public class te3 {
//    return int
    void solution(String[] pricelist, String[] logs) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (String s : pricelist) {
            StringBuilder item = new StringBuilder();
            StringBuilder price = new StringBuilder();
            int divide = 0;
            for (int i = 4; i < s.length(); i++) {
                if (s.charAt(i) == ':') {
                    divide = i + 2;
                    break;
                }
                item.append(s.charAt(i));
            }

            for (int i = divide; i < s.length() - 1; i++) {
                price.append(s.charAt(i));
            }

            map.put(Integer.parseInt(item.toString()), Integer.parseInt(price.toString()));

        }


        for (String s : logs) {
            String[] arr = s.split(" ");
            if (arr[0] == "discount_start") {

            }
        }

    }
}
