package Leetcode.weeklycontest.Normal.NO396;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class t3 {
  public static void main(String[] args) {
    // for the maximum 1e5
    // there's only 35 factor to be count
    // time complexity will greater than O(n) a little bit
    minAnagramLength("abba");
  }

  public static int minAnagramLength(String s) {
    int n = s.length();
    final int max = 100000;
    int cnt = 0;
    for (int i = 1; i < max; ++i) {
      if (max % i == 0) {
        ++cnt;
      }
    }
    System.out.println(cnt);

    for (int k = 1; k <= n; ++k) {
      if (n % k != 0) {
        continue;
      }

      if (check(s, k)) {
        return k;
      }
    }

    return -1;
  }

  public static boolean check(String s, int k) {
    int n = s.length();
    int[] cnt = new int[26];
    for (int i = 0; i < k; ++i) {
      cnt[s.charAt(i) - 'a']++;
    }
    for (int i = k; i < n; i += k) {
      String cur = s.substring(i, i + k);
      int[] arr = new int[26];
      for (char c : cur.toCharArray()) {
        arr[c - 'a']++;
      }

      if (!Arrays.equals(arr, cnt)) {
        return false;
      }
    }


    return true;
  }

}
