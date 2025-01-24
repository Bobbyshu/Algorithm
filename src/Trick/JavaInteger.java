package Trick;

import java.util.HashMap;
import java.util.Map;

public class JavaInteger {
  public boolean isPossibleToRearrange(String s, String t, int k) {
    int n = s.length();
    // System.out.println(n);
    Map<String, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();

    int each = n / k;
    for (int i = 0; i < n; i += each) {
      map1.merge(s.substring(i, i + each), 1, Integer::sum);
      map2.merge(t.substring(i, i + each), 1, Integer::sum);
    }

    for (String key : map1.keySet()) {
      // Integer caching is an optimization mechanism that caches Integer objects for values in the range -128 to 127.
      // This is controlled by an internal Integer Cache
      // and ensures that instances of Integer within this range are reused to save memory and improve performance.
      // out of range will create different instance
      // so we need to use equals to compare the value
      if (!map2.containsKey(key) || !map2.get(key).equals(map1.get(key))) {
        return false;
      }
    }

    return true;
  }
}
