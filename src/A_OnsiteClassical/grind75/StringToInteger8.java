package A_OnsiteClassical.grind75;

public class StringToInteger8 {
  public int myAtoi(String s) {
    s = s.trim();
    // System.out.println(s);
    if (s.length() == 0) {
      return 0;
    }

    long res = 0L;
    if (s.charAt(0) != '-' && s.charAt(0) != '+' && (s.charAt(0) > '9' || s.charAt(0) < '0')) {
      return 0;
    }
    // System.out.println("check");

    boolean negative = false;
    int carry = 1;

    for (int i = 0; i < s.length(); ++i) {
      if (i == 0 && s.charAt(0) == '-') {
        negative = true;
        continue;
      } else if (i == 0 && s.charAt(0) == '+') {
        continue;
      }

      if (s.charAt(i) > '9' || s.charAt(i) < '0') {
        break;
      }

      res = res * 10 + (s.charAt(i) - '0');
      // here we only need to judge MAX_VALUE
      if (!negative && res > Integer.MAX_VALUE) {
        res = Integer.MAX_VALUE;
        break;
      }

      if (negative && res > 1L + Integer.MAX_VALUE) {
        res = Integer.MIN_VALUE;
        break;
      }
    }


    if (negative) {
      res = -res;
    }

    return (int) res;
  }
}
