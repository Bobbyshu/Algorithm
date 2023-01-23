package GuCheng.Fundmental.Algo.BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RangeFrequencyQueries2080 {
  Map<Integer, List<Integer>> map;

  public RangeFrequencyQueries2080(int[] arr) {
    map = new HashMap<>();
    for (int i = 0; i < arr.length; ++i) {
      map.putIfAbsent(arr[i], new ArrayList<>());
      map.get(arr[i]).add(i);
    }
  }

  public int query(int left, int right, int value) {
    if (!map.containsKey(value)) {
      return 0;
    }
    List<Integer> idx = map.get(value);
    // 找到左边第一个等于left的元素和右边第一个大于right的元素
    // 这样二者之差 - 1就是答案
    int l = leftBound(idx, left);
    int r = rightBound(idx, right);
    return r - l;
  }
  //第一个等于target的元素
  public int leftBound(List<Integer> num, int target) {
    int i = 0, j = num.size();
    while (i < j) {
      int mid = (i + j) >> 1;
      if (num.get(mid) < target) {
        i = mid + 1;
      } else {
        j = mid;
      }
    }
    return i;
  }
  //第一个大于target的元素
  public int rightBound(List<Integer> num, int target) {
    int i = 0, j = num.size();
    while (i < j) {
      int mid = (i + j) >> 1;
      if (num.get(mid) > target) {
        j = mid;
      } else {
        i = mid + 1;
      }
    }
    return i;
  }
}
