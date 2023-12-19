package Trick.Sort;

import java.util.Arrays;
// leetcode 953
public class OverwriteSort {
  public boolean isAlienSorted(String[] words, String order) {
    int n = words.length;
    String[] clone = new String[n];
    for (int i = 0; i < n; ++i) {
      clone[i] = words[i];
    }

    int[] cnt = new int[26];
    for (int i = 0; i < 26; ++i) {
      cnt[order.charAt(i) - 'a'] = i;
    }

    Arrays.sort(clone, (o1, o2) -> {
      int len1 = o1.length(), len2 = o2.length();
      int i = 0, j = 0;
      while (i < len1 && j < len2) {
        int c1 = o1.charAt(i) - 'a';
        int c2 = o2.charAt(j) - 'a';
        if (c1 != c2) {
          return cnt[c1] - cnt[c2];
        }
        ++i;
        ++j;
      }
      // swap;
      if (i < len1) {
        return 1;
      }
      // hold
      if (j < len2) {
        return -1;
      }
      return 0;
    });

    return Arrays.equals(clone, words);
  }
}
