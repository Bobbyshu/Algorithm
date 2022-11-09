package Algorithm.SlidingWindow.Formwork;

import java.util.HashMap;
import java.util.Map;

public class sliding_window {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n < 2)
            return n;

        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int len = 0;

        while (right < n) {
            //这里要找个变量记录当前位置的值下来，不然right增加了就出现空指针了
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            right++;

            //填入导致循环无法继续进行下去的条件
            while (map.get(c) > 1) {
                char d = s.charAt(left);
                map.put(d, map.get(d) - 1);
                left++;
            }

            len = Math.max(len, right - left);
        }

        return len;
    }
}
