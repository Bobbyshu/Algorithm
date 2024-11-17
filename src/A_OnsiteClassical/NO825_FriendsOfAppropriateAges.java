package A_OnsiteClassical;

import java.util.Arrays;

public class NO825_FriendsOfAppropriateAges {
  public int numFriendRequests(int[] ages) {
    Arrays.sort(ages);

    int n = ages.length, res = 0;

    for (int k = 0; k < n; ++k) {
      int l = 0, r = 0;
      while (l < k && !check(ages[l], ages[k])) {
        ++l;
      }
      if (r < k) {
        r = k;
      }

      while (r < n && check(ages[r], ages[k])) {
        ++r;
      }

      if (r > l) {
        res += r - l - 1;
      }
    }

    return res;
  }

  private boolean check(int x, int y) {
    if (y <= 0.5 * x + 7 || y > x) {
      return false;
    }

    return true;
  }
}
