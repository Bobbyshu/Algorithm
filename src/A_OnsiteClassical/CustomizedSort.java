package A_OnsiteClassical;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomizedSort {
  public static List<String> sortCustomize(String s, List<String> p) {

    Map<Character, Integer> charOrderMap = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      charOrderMap.put(s.charAt(i), i);
    }
    Collections.sort(p, (String s1, String s2) -> {
      int minLength = Math.min(s1.length(), s2.length());
      for (int i = 0; i < minLength; i++) {
        char c1 = s1.charAt(i);
        char c2 = s2.charAt(i);
        if (c1 != c2) {
          return charOrderMap.get(c1) - charOrderMap.get(c2);
        }
      }
      return s1.length() - s2.length();
    });

    return p;
  }
}
