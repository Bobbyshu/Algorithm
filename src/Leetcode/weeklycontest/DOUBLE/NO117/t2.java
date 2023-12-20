package Leetcode.weeklycontest.DOUBLE.NO117;

public class t2 {
  // A B C
  // A -> 0 - min(limit, n)
  // B -> 0 - limit && j <= n - i
  // C -> fixed -> n - i - j && 0 <= n - i - j <= limit
  // A + B + C == n
  public long distributeCandies(int n, int limit) {
    long res = 0L;

    // enumerate first guy's candy
    for (int i = 0; i <= Math.min(n, limit); ++i) {
      int remain = n - i;
      if (remain > 2 * limit) {
        continue;
      } else if (remain <= limit) { // B -> left + 1;
        res += (remain + 1);
      } else {    // limit < remain <= 2 * limit --> B -> [remain - limit, limit]
        res += (2 * limit - remain + 1);
      }
    }

    return res;
  }
}
