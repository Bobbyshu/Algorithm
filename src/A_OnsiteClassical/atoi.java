package A_OnsiteClassical;

public class atoi {
  public static void main(String[] args) {
    myAtoi("   -42");
  }

  public static int myAtoi(String s) {
    s = s.trim();
    if (s.isEmpty()) {
      return 0;
    }

    if (!Character.isDigit(s.charAt(0))
        && s.charAt(0) != '-' && s.charAt(0) != '+') {
      return 0;
    }

    long res = 0L;
    boolean neg = s.charAt(0) == '-';
    int i = !Character.isDigit(s.charAt(0)) ? 1 : 0;

    while (i < s.length() && Character.isDigit(s.charAt(i))) {
      res = res * 10 + (s.charAt(i++) - '0');
      if (!neg && res > Integer.MAX_VALUE) {
        res = Integer.MAX_VALUE;
        break;
      }
      if (neg && res > 1L + Integer.MAX_VALUE) {
        res = 1L + Integer.MAX_VALUE;
        break;
      }
    }
    return neg ? (int) -res : (int) res;
  }
}
