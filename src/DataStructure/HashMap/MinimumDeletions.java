package DataStructure.HashMap;

import java.util.HashSet;
import java.util.Set;

public class MinimumDeletions {
  public int minDeletions(String s) {
    int[] cnt = new int[26];
    for (char c : s.toCharArray()) {
      cnt[c - 'a']++;
    }

    Set<Integer> set = new HashSet<>();
    int res = 0;
    for (int c : cnt) {
      if (c != 0) {
        while (set.contains(c)) {
          --c;
          ++res;
        }
        if (c != 0) {
          set.add(c);
        }
      }
    }

    return res;
  }
}
