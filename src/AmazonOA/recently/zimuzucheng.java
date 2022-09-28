package AmazonOA.recently;

import java.util.HashMap;
import java.util.Map;

public class zimuzucheng {
    public static void main(String[] args) {
        zimuzucheng z = new zimuzucheng();
        String s1 = "mononom", s2 = "mon";
        System.out.println(z.countMaximumOperation(s1, s2));
    }
    int countMaximumOperation(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : s.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        int res = Integer.MAX_VALUE;
        for (char c : t.toCharArray()) {
            res = Math.min(res, map1.get(c) / map2.get(c));
        }

        return res;
    }

}
