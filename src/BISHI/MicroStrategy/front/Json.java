package BISHI.MicroStrategy.front;

import java.util.*;

public class Json {
  public static List<String> getJSONDiff(String json1, String json2) {
    // Write your code here
    List<String> res = new ArrayList<>();
    Map<String, String> map1 = process(json1);
    Map<String, String> map2 = process(json2);


    for (String key : map1.keySet()) {
      if (map2.containsKey(key)) {
        String s1 = map1.get(key);
        String s2 = map2.get(key);

        if (!s1.equals(s2)) {
          res.add(key);
        }
      }
    }
    // System.out.println(res);
    Collections.sort(res);
    return res;
  }

  private static Map<String, String> process(String s) {
    Map<String, String> map = new HashMap<>();

    String[] keyValuePairs = s.replaceAll("[{}]", "").split(",");

    for (String keyValue : keyValuePairs) {
      String[] str = keyValue.split(":");
      if (str.length == 2) {
        String key = str[0].trim().replaceAll("\"", "");
        String value = str[1].trim().replaceAll("\"", "");
        map.put(key, value);
      }
    }

    return map;
  }
}
