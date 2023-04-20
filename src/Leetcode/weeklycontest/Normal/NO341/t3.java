package Leetcode.weeklycontest.Normal.NO341;

import java.util.HashMap;
import java.util.Map;

public class t3 {
  public int addMinimum(String word) {
    String pattern = "abc";
    int i = 0;
    int count = 0;
    while (i < word.length()) {
      if (word.charAt(i) == pattern.charAt(i % 3)) {
        i++;
      } else {
        count++;
        word = word.substring(0, i) + pattern.charAt(i % 3) + word.substring(i);
      }
    }
    while (i % 3 != 0) {
      count++;
      word += pattern.charAt(i % 3);
      i++;
    }
    return count;
  }
}
