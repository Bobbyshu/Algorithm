package BitManipulation;

import java.util.HashMap;
import java.util.Map;

public class MaximumProductOfWordLengths {
  public static void main(String[] args) {
    int n1 = 1 << 3;
    System.out.println(n1);
    int n2 = 1 << 4;
    System.out.println(n2);

    int n3 = 0 | n1;
    System.out.println(n3);
    int n4 = n3 | n2;
    System.out.println(n4);
  }

  // for same cur, just register maximum length
  public int maxProductOptimized(String[] words) {
    Map<Integer, Integer> map = new HashMap<>();
    for (String s : words) {
      int cur = 0;
      for (char c : s.toCharArray()) {
        int bit = c - 'a';
        cur |= (1 << bit);
      }
      // register maximum length in cur bit
      if (!map.containsKey(cur) || map.get(cur) < s.length()) {
        map.put(cur, s.length());
      }
    }

    int res = 0;
    for (int k1 : map.keySet()) {
      for (int k2 : map.keySet()) {
        if (((k1 & k2)) == 0) {
          res = Math.max(res, map.get(k1) * map.get(k2));
        }
      }
    }

    return res;
  }


  // unoptimized version
  public int maxProduct(String[] words) {
    int n = words.length, idx = 0;
    int[] masks = new int[n];

    for (String s : words) {
      int cur = 0;
      for (char c : s.toCharArray()) {
        int bit = c - 'a';
        // use cur to register each bit
        // ex: 0 | 2^4 => 10000(d)
        // 10000 | 5(e) => 10000 | 100000 => 110000(de)
        cur |= (1 << bit);
      }
      masks[idx++] = cur;
    }

    int res = 0;
    for (int i = 0; i < n; ++i) {
      for (int j = i + 1; j < n; ++j) {
        // check whether there's overlap bit
        if ((masks[i] & masks[j]) == 0) {
          res = Math.max(res, words[i].length() * words[j].length());
        }
      }
    }

    return res;
  }
}
