package A_OnsiteClassical.Tiktok;

public class NO76_MinimumWindowSubstring {
  // T: O(∣Σ∣ * m + n)
  // S: O(∣Σ∣)
  public String minWindow(String s, String t) {
    int[] cnt = new int[128];
    for (char c : t.toCharArray()) {
      cnt[c]++;
    }

    int[] cur = new int[128];
    int l = 0, r = 0;
    int resLeft = -1, resRight = -1, res = Integer.MAX_VALUE;
    while (r < s.length()) {
      cur[s.charAt(r)]++;
      while (check(cur, cnt)) {
        if (r - l + 1 < res) {
          res = r - l + 1;
          resLeft = l;
          resRight = r;
        }
        cur[s.charAt(l)]--;
        ++l;
      }

      ++r;
    }

    return resLeft == -1 ? "" : s.substring(resLeft, resRight + 1);
  }

  private boolean check(int[] cnt1, int[] cnt2) {
    for (int i = 0; i < 128; ++i) {
      if (cnt2[i] > cnt1[i]) {
        return false;
      }
    }

    return true;
  }
}
