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

  public int numFriendRequests2(int[] ages) {
    int[] cnt = new int[121];
    for (int age : ages) {
      cnt[age]++;
    }

    int res = 0;
    int r = 0;
    int len = 0;
    for (int l = 0; l < cnt.length; l++) {
      len += cnt[l];
      if (r * 2 <= l + 14) { // 不能发送好友请求
        len -= cnt[r];
        r++;
      }
      if (len > 0) { // 存在可以发送好友请求的用户
        res += cnt[l] * len - cnt[l];
      }
    }
    return res;
  }
}
