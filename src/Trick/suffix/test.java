package Trick.suffix;

import java.util.ArrayList;
import java.util.List;

public class test {
  public int countDistinct(int[] nums, int k, int p) {
    List<List<Integer>> list = new ArrayList<>();
    int n = nums.length, res = 0;
    for (int i = 0; i < n; i++) {
      List<Integer> path = new ArrayList<>();
      for (int j = i; j < n; j++) {
        path.add(nums[j]);
        list.add(new ArrayList<>(path));
      }
    }

    for (List<Integer> l : list) {
      int cnt = k;
      for (int i = 0; i < l.size(); ++i) {
        if (cnt < 0) {
          break;
        }
        System.out.println(l.get(i));
        if ((l.get(i) % p) == 0) {
          --cnt;
        }
      }
      if (cnt >= 0) {
        ++res;
      }
    }

    return res;
  }
}
