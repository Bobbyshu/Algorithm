package Leetcode.weeklycontest.Normal.NO421;

import java.util.Arrays;

public class T2 {
  public static void main(String[] args) {
    lengthAfterTransformations("abcyy", 2);
  }
  public static int lengthAfterTransformations(String s, int t) {
    int mod = (int) 1e9+7;

    long[] cnt = new long[26];

    for (char c : s.toCharArray()) {
      cnt[c - 'a']++;
    }
    // System.out.println(Arrays.toString(cnt));

    for (int i = 0; i < t; ++i) {
      int[] next = new int[26];

      // process a to y
      for (int j = 0; j < 25; ++j) {
        next[j + 1] = (int) cnt[j];
      }

      // process z
      next[0] = (int) (next[0] + cnt[25]) % mod;
      next[1] = (int) (next[1] + cnt[25]) % mod;

      for (int j = 0; j < 26; ++j) {
        cnt[j] = next[j];
      }
      // System.out.println("i = " + i);
      // System.out.println(Arrays.toString(cnt));
    }

    // System.out.println(Arrays.toString(cnt));

    long res = 0;
    for (var c : cnt) {
      res = (res + c) % mod;
    }

    return (int) res;
  }
}
