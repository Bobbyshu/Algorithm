package Trick;

import java.util.HashMap;
import java.util.Map;

public class hashmap {
  void show(int[] arr) {
    Map<Integer, Integer> cnt = new HashMap<>();
    // merge() 方法会先判断指定的 key 是否存在，如果不存在，则添加键值对到 hashMap 中。
    //  merge() 方法的语法为：
    // hashmap.merge(key, value, remappingFunction)
    // 相当于 map.put(x, map.getOrDefault(x, 0) + 1);
    for (int x : arr) {
      cnt.merge(x, 1, Integer::sum);
    }
  }
}
