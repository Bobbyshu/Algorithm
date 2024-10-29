package A_OnsiteClassical.Tiktok;

public class NO921_MinimumAddMakeParenthesesValid {
  // 要考虑)在(前面的情况
  public int minAddToMakeValid(String s) {
    int left = 0, right = 0;
    for (char c : s.toCharArray()) {
      if (c == '(') {
        ++left;
      } else {
        if (left > 0) {
          --left;
        } else {
          // can't be offset
          ++right;
        }
      }
      // System.out.println(cnt);
    }
    return left + right;
  }
}
