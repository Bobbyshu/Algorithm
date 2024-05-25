package Leetcode.weeklycontest.Normal.NO398;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class t3 {
  // n = nums.length (1e5)
  // m = nums[1].length(10)
  // traverse: O(nm)
  // check: O(nm^2)
  public long sumDigitDifferencesInArray(int[] nums) {
    int len = String.valueOf(nums[0]).length();
    int[][] arr = new int[len][10];
    for (int j = 0; j < len; ++j) {
      for (int i = 0; i < nums.length; ++i) {
        String s = String.valueOf(nums[i]);
        int idx = s.charAt(j) - '0';
        arr[i][idx]++;
      }
    }
//    System.out.println(Arrays.deepToString(arr));
    long res = 0L;
    for (int num : nums) {
      String s = String.valueOf(num);
      for (int i = 0; i < len; ++i) {
        int[] cnt = arr[i];
        int cur = s.charAt(i) - '0';
        for (int j = 0; j < 10; ++j) {
          if (j == cur) {
            continue;
          }
          res += cnt[j];
        }
      }
    }

    return res / 2;
  }
  public long sumDigitDifferences(int[] nums) {
    int n = String.valueOf(nums[0]).length();
    Map<Character, Integer>[] table = new Map[n];
    for (int i = 0; i < n; ++i) {
      table[i] = new HashMap<>();
    }

    for (int j = 0; j < n; ++j) {
      for (int i = 0; i < nums.length; ++i) {
        String s = String.valueOf(nums[i]);
        table[j].merge(s.charAt(j), 1, Integer::sum);
        // System.out.println(table[j]);
      }
    }

    // System.out.println(Arrays.toString(table));
    long res = 0L;
    for (int num : nums) {
      String s = String.valueOf(num);
      for (int i = 0; i < n; ++i) {
        Map<Character, Integer> cur = table[i];
        char c = s.charAt(i);
        for (char ch : cur.keySet()) {
          if (ch != c) {
            res += cur.get(ch);
          }
        }
      }
    }

    return res / 2;
  }
}
