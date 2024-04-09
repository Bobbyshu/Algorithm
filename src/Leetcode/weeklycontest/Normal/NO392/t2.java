package Leetcode.weeklycontest.Normal.NO392;

public class t2 {
  public String getSmallestString(String s, int k) {
    if (k == 0) {
      return s;
    }

    // z b b z
    // k = 3
    // cur = 25
    // arr[i] = 'a'
    // k -= 1
    // cur = 1
    // x a x c d
    // k = 4
    // x = 23
    char[] arr = s.toCharArray();
    for (int i = 0; i < arr.length; ++i) {
      int cur = arr[i] - 'a';
      if (cur == 0) {
        continue;
      }

      if (cur <= k || cur + k >= 26) {
        arr[i] = 'a';
        k -= Math.min(cur, 26 - cur);
      } else {
        cur = Math.min(cur - k, (cur + k) % 26);
        arr[i] = (char) (cur + 'a');
        k = 0;
      }

      if (k == 0) {
        return new String(arr);
      }
    }

    return new String(arr);
  }
}
