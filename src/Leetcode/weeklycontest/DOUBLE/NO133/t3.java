package Leetcode.weeklycontest.DOUBLE.NO133;

public class t3 {
  // 是否需要反转和翻转次数奇偶性有关
  public int minOperations(int[] nums) {
    int res = 0;
    for (int n : nums) {
      if (n == res % 2) {
        ++res;
      }
    }
    return res;
  }
}
