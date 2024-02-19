package Leetcode.weeklycontest.DOUBLE.NO121;

public class T2 {
  /**
   * 设 nums 的异或和为 s。
   *
   * s == k 等价于 s ^ k = 0
   *
   * 设 x = s ^ k
   * 我们把 nums 中的任意数字的某个比特位翻转，那么 x 的这个比特位也会翻转。
   * 要让 x = 0，就必须把 x 中的每个 1 都翻转，所以 x 中的 1 的个数就是我们的操作次数。
   *
   */
  public int minOperations(int[] nums, int k) {
    for (int n : nums) {
      k ^= n;
    }

    String s = Integer.toBinaryString(k);
    int cnt = 0;
    for (char c : s.toCharArray()) {
      if (c == '1') {
        ++cnt;
      }
    }
    return cnt;
  }
}
