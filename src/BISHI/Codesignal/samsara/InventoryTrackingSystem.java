package BISHI.Codesignal.samsara;

import java.util.*;

public class InventoryTrackingSystem {
    public static void main(String[] args) {
        String[][] logs = {{"supply", "item1", "2", "100"},
                            {"supply", "item2", "3", "60"},
                            {"sell", "item1", "1"},
                            {"sell", "item1", "1"},
                {"sell", "item2", "2"},
                {"return", "item2", "1", "60", "40"},
                {"sell", "item2", "1"},
                {"sell", "item2", "1"}};
        System.out.println(Arrays.toString(solution(logs)));
    }

    static int[] solution(String[][] logs) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> discountMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int discount = 0;

        for (String[] s : logs) {
            if (s[0].equals("supply")) {
                map.put(s[1], Integer.valueOf(s[3]));
            } else if (s[0].equals("return")) {
                discountMap.put(s[1], Integer.valueOf(s[4]));
                discount = Integer.parseInt(s[2]);
            } else {
                if (discount > 0) {
                    list.add(discountMap.get(s[1]));
                    discount--;
                } else {
                    list.add(Integer.parseInt(s[2]) * map.get(s[1]));
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
