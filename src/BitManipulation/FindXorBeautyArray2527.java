package BitManipulation;

public class FindXorBeautyArray2527 {
  /**
   *
   * (a | a) & a     (b | a) & a     (c | a) & a
   * (a | a) & b     (b | a) & b     (c | a) & b
   * (a | a) & c     (b | a) & c     (c | a) & c
   *
   * (a | b) & a     (b | b) & a     (c | b) & a
   * (a | b) & b     (b | b) & b     (c | b) & b
   * (a | b) & c     (b | b) & c     (c | b) & c
   *
   * (a | c) & a     (b | c) & a     (c | c) & a
   * (a | c) & b     (b | c) & b     (c | c) & b
   * (a | c) & c     (b | c) & c     (c | c) & c
   *
   * x | y = y | x
   *
   * conclude
   *
   * (a | a) & a     (b | b) & a     (c | c) & a
   * (a | a) & b     (b | b) & b     (c | c) & b
   * (a | a) & c     (b | b) & c     (c | c) & c
   *
   * a | a = a, a & a = a
   *
   *   a       b & a     c & a
   * a & b       b       c & b
   * a & c     b & c       c
   *
   * x & y = y & x
   *
   * a ^ b ^ c -> all the elements inside nums ^
   */
  public int xorBeauty(int[] nums) {
    int res = 0;
    for (int n : nums) {
      res ^= n;
    }
    return res;
  }
}
