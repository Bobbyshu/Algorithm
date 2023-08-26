package Leetcode.weeklycontest.Normal.NO344;

import java.util.HashMap;
import java.util.Map;

public class t2 {
  public static void main(String[] args) {
    FrequencyTracker ft = new FrequencyTracker();
    ft.deleteOne(3);
    ft.add(9);
    ft.add(9);
    ft.add(4);
    ft.hasFrequency(2);
    ft.deleteOne(2);
    ft.add(9);
    ft.add(9);
    ft.hasFrequency(3);
    ft.deleteOne(9);
    ft.deleteOne(1);
    ft.add(6);
  }
}

class FrequencyTracker {

  int[] cnt;
  Map<Integer, Integer> map;

  public FrequencyTracker() {
    cnt = new int[100001];
    map = new HashMap<>();
  }

  public void add(int number) {
    if (map.containsKey(cnt[number])) {
      map.put(cnt[number], map.getOrDefault(cnt[number], 0) - 1);
      if (map.get(cnt[number]) == 0) {
        map.remove(cnt[number]);
      }
    }
    cnt[number]++;
    map.put(cnt[number], map.getOrDefault(cnt[number], 0) + 1);
  }

  public void deleteOne(int number) {
    if (cnt[number] > 0) {
      map.put(cnt[number], map.get(cnt[number]) - 1);
      if (map.get(cnt[number]) == 0) {
        map.remove(cnt[number]);
      }

      cnt[number]--;
      if (cnt[number] != 0) {
        map.put(cnt[number], map.get(cnt[number]) + 1);
      }
    }
  }

  public boolean hasFrequency(int frequency) {
    // System.out.println(map);
    return map.containsKey(frequency);
  }
}

