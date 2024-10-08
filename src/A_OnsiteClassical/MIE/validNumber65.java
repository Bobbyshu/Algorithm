package A_OnsiteClassical.MIE;

public class validNumber65 {
  public boolean isNumber(String s) {
    int n = s.length();
    char[] arr = s.toCharArray();
    int idx = -1;

    for (int i = 0; i < n; ++i) {
      if (arr[i] == 'e' || arr[i] == 'E') {
        if (idx == -1) {
          idx = i;
        } else {
          // got second E/e
          return false;
        }
      }
    }

    boolean res = true;
    // got e separate
    if (idx != -1) {
      res &= check(arr, 0, idx - 1, false);
      res &= check(arr, idx + 1, n - 1, true);
    } else {
      res &= check(arr, 0, n - 1, false);
    }

    return res;
  }

  private boolean check(char[] arr, int l, int r, boolean mustInteger) {
    // when e/E located at first or end
    if (l > r) {
      return false;
    }

    if (arr[l] == '+' || arr[l] == '-') {
      ++l;
    }

    boolean hasDot = false, hasNum = false;
    for (int i = l; i <= r; ++i) {
      if (arr[i] == '.') {
        // only int available in right side
        if (mustInteger || hasDot) {
          return false;
        }
        hasDot = true;
      } else if (arr[i] >= '0' && arr[i] <= '9') {
        hasNum = true;
      } else {
        return false;
      }
    }

    return hasNum;
  }
}
