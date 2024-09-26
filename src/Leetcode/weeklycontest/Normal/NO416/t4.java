package Leetcode.weeklycontest.Normal.NO416;

public class t4 {
  public long validSubstringCount(String word1, String word2) {
    int[] cnt1 = new int[26], cnt2 = new int[26];

    for (char c : word2.toCharArray()) {
      cnt2[c - 'a']++;
    }

    long res = 0L;
    int r = 0, l = 0;
    char[] arr = word1.toCharArray();
    while (r < word1.length()) {
      cnt1[arr[r] - 'a']++;
      long cur = res;
      while (check(cnt1, cnt2)) {
        cnt1[arr[l++] - 'a']--;
        res += l;
        // System.out.println("l = " + l + " r = " + r + " res = " + res);
      }

      ++r;
    }

    return res;
  }

  private boolean check(int[] cnt1, int[] cnt2) {
    for (int i = 0; i < 26; ++i) {
      if (cnt1[i] < cnt2[i] || (cnt1[i] > 0 && cnt2[i] == 0)) {
        return false;
      }
    }

    return true;
  }
}
