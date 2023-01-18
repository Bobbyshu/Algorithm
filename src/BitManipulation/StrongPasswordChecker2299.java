package BitManipulation;

import java.util.HashSet;
import java.util.Set;

/*
用左侧第1～4位分别表示 小写字母、大写字母、数字、特殊字符 遍历字符串，用或运算，最后这四位都有即可
 */
public class StrongPasswordChecker2299 {
  public boolean strongPasswordCheckerII(String password) {
    int n = password.length();
    if (n < 8) {
      return false;
    }

    char[] arr = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'};
    Set<Character> set = new HashSet<>();
    for (char c : arr) {
      set.add(c);
    }

    int res = 0;
    for (int i = 0; i < n; ++i) {
      char c = password.charAt(i);
      if (i > 0 && c == password.charAt(i - 1)) {
        return false;
      }
      if (Character.isLowerCase(c)) {
        res |= 1;
      }
      if (Character.isUpperCase(c)) {
        res |= 2;
      }
      if (Character.isDigit(c)) {
        res |= 4;
      }

      if (set.contains(c)) {
        res |= 8;
      }
    }
    return res == 15;
  }
}
