package A_OnsiteClassical.Tiktok;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
  // Time complexity: O(n) * O(m) * O(26) where n = strs.length
  // Space complexity: in worse case, every string inside of strs will have
  // separate group. So, we should create O(n) keys and store O(26m) values,
  // So, Space complexity should be O(n) * + O(26m)
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();

    for (String s : strs) {
      int[] cur = new int[26];
      for (char c : s.toCharArray()) {
        cur[c - 'a']++;
      }
      // System.out.println(Arrays.toString(cur));
      String curArr = encode(cur);
      // System.out.println(curArr);
      map.putIfAbsent(curArr, new ArrayList<>());
      map.get(curArr).add(s);
    }

    List<List<String>> res = new ArrayList<>();
    for (List<String> lst : map.values()) {
      res.add(new ArrayList<>(lst));
    }

    return res;
  }

  // O(26)
  private String encode(int[] arr) {
    StringBuilder sb = new StringBuilder();
    for (int a : arr) {
      sb.append(a).append(',');
    }

    return sb.toString();
  }

  public List<List<String>> groupAnagramsBetter(String[] strs) {
    Map<String, List<String>> codeToGroup = new HashMap<>();

    for (String s : strs) {
      String code = encode(s);
      codeToGroup.putIfAbsent(code, new ArrayList<>());
      codeToGroup.get(code).add(s);
    }

    List<List<String>> res = new ArrayList<>();
    for (List<String> group : codeToGroup.values()) {
      res.add(group);
    }

    return res;
  }

  String encode(String s) {
    char[] count = new char[26];

    for (char c : s.toCharArray()) {
      count[c - 'a']++;
    }

    return new String(count);
  }
}
