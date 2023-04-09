package Leetcode.weeklycontest.Normal.NO336;

import java.util.HashSet;
import java.util.Set;

public class t1 {
  public int vowelStrings(String[] words, int left, int right) {
    char[] arr ={'a', 'e','i','o','u'};
    Set<Character> set = new HashSet<>();
    for (char c : arr) {
      set.add(c);
    }

    int res = 0;
    for (int i = left; i <= right; ++i) {
      String w = words[i];
      if (set.contains(w.charAt(0)) && set.contains(w.charAt(w.length() - 1))) {
        ++res;
      }
    }

    return res;
  }
}
