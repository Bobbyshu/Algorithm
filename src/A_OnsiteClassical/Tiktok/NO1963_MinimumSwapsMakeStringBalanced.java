package A_OnsiteClassical.Tiktok;

public class NO1963_MinimumSwapsMakeStringBalanced {
  // to make min swap
  // we need to always swap the ']' to the rightMost index
  // cuz rightMost can make more legal []
  public int minSwaps(String s) {
    int left = 0, res = 0;
    for (char c : s.toCharArray()) {
      if (c == '[') {
        ++left;
      } else {
        if (left > 0) {
          --left;
        } else {
          // equals to we swap the rightMost [
          // to current illegal ]
          // so the left [ increase
          // swap times ++
          ++left;
          ++res;
        }
      }
    }

    return res;
  }
}
