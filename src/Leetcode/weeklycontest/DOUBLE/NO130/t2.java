package Leetcode.weeklycontest.DOUBLE.NO130;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class t2 {
  public int findWinningPlayer(int[] skills, int k) {
    int n = skills.length;
    if (k >= n - 1) {
      int maxIdx = -1, max = Integer.MIN_VALUE;
      for (int i = 0; i < n; ++i) {
        if (skills[i] > max) {
          max = skills[i];
          maxIdx = i;
        }
      }
      return maxIdx;
    }

    Deque<Integer> deque = new ArrayDeque<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; ++i) {
      deque.addLast(skills[i]);
      map.put(skills[i], 0);
    }



    while (map.get(deque.peekFirst()) < k) {
      int first = deque.pollFirst(), second = deque.pollFirst();
      if (first > second) {
        map.merge(first, 1, Integer::sum);
        deque.addLast(second);
        deque.addFirst(first);
      } else {
        map.merge(second, 1, Integer::sum);
        deque.addLast(first);
        deque.addFirst(second);
      }
    }

    // System.out.println(map);

    for (int i = 0; i < n; ++i) {
      if (skills[i] == deque.peekFirst()) {
        return i;
      }
    }
    return -1;
  }
}
