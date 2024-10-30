package A_OnsiteClassical.Tiktok;

import java.util.Random;

public class NO528_RandomPickWithWeight {
  int[] prefix;
  Random random;

  public NO528_RandomPickWithWeight(int[] w) {
    prefix = new int[w.length + 1];
    for (int i = 1; i <= w.length; ++i) {
      prefix[i] = prefix[i - 1] + w[i - 1];
    }

    random = new Random();
  }

  public int pickIndex() {
    int n = prefix.length;
    int t = (int) (Math.random() * prefix[n - 1]) + 1;
    int l = 1, r = n - 1;
    while (l < r) {
      int mid = (l + r) / 2;
      if (prefix[mid] >= t) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return r - 1;
  }
}
