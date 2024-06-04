package Leetcode.weeklycontest.Normal.NO399;

import java.util.HashMap;
import java.util.Map;

public class T3 {
  public static void main(String[] args) {
    int[] n1 = {1,3,4}, n2 = {1,3,4};

  }
  // map1 store nums1[i] / k occurrences
  // map2 store nums2[j] occurrences
  // get the ceiling number -> map1 key which means the maximum number nums2[j] could reach
  // map1.freq*map2.freq -> if satisfied requirement
  // enumerate the key in map2 and calculate the product of frequency
  public long numberOfPairs(int[] nums1, int[] nums2, int k) {
    Map<Double, Integer> map1 = new HashMap<>();
    Map<Integer, Integer> map2 = new HashMap<>();
    for (int n : nums1) {
      double d = (double) n / k;
      map1.merge(d, 1, Integer::sum);
    }

    for (int n : nums2) {
      map2.merge(n, 1, Integer::sum);
    }

    double max = 0;
    for (double key : map1.keySet()) {
      max = Math.max(max, key);
    }

    // System.out.println(map1);
    // System.out.println(map2);
    // System.out.println(max);

    long res = 0L;
    for (int key : map2.keySet()) {
      for (double time = 1; time * key <= max; ++time) {
        if (map1.containsKey(time * key)) {
          res += (long) map1.get(time * key) * (long) map2.get(key);
        }
      }
    }

    return res;
  }
}
