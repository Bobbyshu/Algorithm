package Leetcode.weeklycontest.DOUBLE.NO98;

public class t1 {
  public static void main(String[] args) {
    minMaxDifference(11891);
  }
  public static int minMaxDifference(int num) {
    String s = num + "";
    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    for (int i = 0; i < s.length(); ++i) {
      char[] arr = s.toCharArray();
      char[] temp = s.toCharArray();
      char cur = arr[i];
      for (char c = '0'; c <= '9'; ++c) {
        for (int j = 0; j < s.length(); ++j) {
          if (arr[j] == cur) {
            arr[j] = c;
          }
        }
        max = Math.max(max, Integer.parseInt(new String(arr)));
        min = Math.min(min, Integer.parseInt(new String(arr)));
        reset(arr, temp);
      }
    }
    return max - min;
  }

  static void reset(char[] arr, char[] temp) {
    for (int i = 0; i < arr.length; ++i) {
      arr[i] = temp[i];
    }
  }
}
