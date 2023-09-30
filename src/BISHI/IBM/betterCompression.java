package BISHI.IBM;

import java.util.HashMap;
import java.util.Map;

public class betterCompression {
  public static String comp(String s) {
    Map<Character, Integer> map = new HashMap<>();

    int i = 0;
    while (i < s.length()) {
      char c = s.charAt(i);
      i++;
      int cur = 0;
      while (i < s.length() && Character.isDigit(s.charAt(i))) {
        cur = cur * 10 + (s.charAt(i) - '0');
        i++;
      }

      map.put(c, map.getOrDefault(c, 0) + cur);
    }

    StringBuilder res = new StringBuilder();
    for (char c = 'a'; c <= 'z'; c++) {
      if (map.containsKey(c)) {
        res.append(c).append(map.get(c));
      }
    }

    return res.toString();
  }

  public static void main(String[] args) {
    String input = "a3c9b2c1";
    String result = comp(input);
    System.out.println(result);
  }
}
