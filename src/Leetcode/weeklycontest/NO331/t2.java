package Leetcode.weeklycontest.NO331;

import java.util.HashSet;
import java.util.Set;

public class t2 {
  public int[] vowelStrings(String[] words, int[][] queries) {
    char[] arr = {'a', 'e', 'i', 'o', 'u'};
    Set<Character> set = new HashSet<>();
    for (char c : arr) {
      set.add(c);
    }

    int n = words.length;
    int[] cnt = new int[n];

    for (int i = 0; i < n; ++i) {
      char c = words[i].charAt(0);
      char d = words[i].charAt(words[i].length() - 1);
      if (set.contains(c) && set.contains(d)) {
        cnt[i] = 1;
      }
    }

    int[] prefix = new int[n + 1];
    for (int i = 1; i <= n; ++i) {
      prefix[i] = prefix[i - 1] + cnt[i - 1];
    }

    int[] res = new int[queries.length];
    for (int i = 0; i < queries.length; ++i) {
      int[] q = queries[i];
      res[i] = prefix[q[1] + 1] - prefix[q[0]];
    }

    return res;
  }
}
