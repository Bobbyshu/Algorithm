package GuCheng.Fundmental.Algo.F_TwoPointer.SlidingWindow.SameDirection;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters3 {
  public int lengthOfLongestSubstring(String s) {
    if (s.length() == 0) {
      return 0;
    }
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    int max = 0;
    int left = 0;
    //枚举的好处在于处理的时候，是最后才计算right++，这样就不会出现要记录之前存在的right的情况
    //但是统计的时候也要
    for (int i = 0; i < s.length(); i++) {
      if (map.containsKey(s.charAt(i))) {
        left = Math.max(left, map.get(s.charAt(i)) + 1);
      }
      map.put(s.charAt(i), i);
      max = Math.max(max, i - left + 1);
    }
    return max;
  }

  public int lengthOfLongestSubstring2(String s) {
    if (s.length() == 0) {
      return 0;
    }

    Map<Character, Integer> map = new HashMap<Character, Integer>();
    int max = 0;
    int left = 0, right = 0;
    //while的写法
    while (right < s.length()) {
      char c = s.charAt(right);
      ++right;
      map.put(c, map.getOrDefault(c, 0) + 1);
      while (map.get(c) > 1) {
        map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
        ++left;
      }
      max = Math.max(max, right - left);
    }

    return max;
  }
}
