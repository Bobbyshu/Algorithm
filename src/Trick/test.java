package Trick;

import java.util.HashMap;
import java.util.Map;

public class test {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int res = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int times = entry.getValue();
            String s = entry.getKey();
            if (isValid(s)) {
                res += map.get(s);
            }
            if (map.containsKey(reverse(s))) {
                res += Math.min(map.get(s), map.get(reverse(s)));
                map.remove(reverse(s));
            }
        }
        return res;
    }

    String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    boolean isValid(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
