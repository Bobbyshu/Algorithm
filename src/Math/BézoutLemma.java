package Math;

// 设 a,b 是不全为零的整数，则存在整数 x,y, 使得 ax+by=gcd(a,b)。
public class BézoutLemma {
  public boolean isGoodArray(int[] nums) {
    int divisor = nums[0];
    for (int n : nums) {
      divisor = gcd(divisor, n);
      if (divisor == 1) {
        return true;
      }
    }
    return false;
  }

  int gcd(int a, int b) {
    return a == 0 ? b : gcd(b % a, a);
  }
}
