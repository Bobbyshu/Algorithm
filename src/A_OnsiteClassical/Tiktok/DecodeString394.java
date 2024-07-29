package A_OnsiteClassical.Tiktok;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString394 {
  public String decodeString(String s) {
    Deque<Integer> cnt = new ArrayDeque<>();
    Deque<String> dict = new ArrayDeque<>();

    StringBuilder sb = new StringBuilder();
    int num = 0;

    for (char c : s.toCharArray()) {
      if (c == '[') {
        cnt.add(num);
        dict.add(sb.toString());
        // clear
        num = 0;
        sb = new StringBuilder();
      } else if (c == ']') {
        int cur = cnt.pollLast();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < cur; ++i) {
          temp.append(sb);
        }
        sb = new StringBuilder(dict.pollLast()).append(temp);
      } else if (c <= '9' && c >= '0') {
        num = 10 * num + c - '0';
      } else if (c <= 'z' && c >= 'a') {
        sb.append(c);
      }
    }

    return sb.toString();
  }
}
