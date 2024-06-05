package Leetcode.weeklycontest.Normal.NO400;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class t3 {
  public String clearStars(String s) {
    // after * we can append
    // we need to delete
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[0] == o2[0]) ? o2[1] - o1[1] : o1[0] - o2[0]);
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) != '*') {
        pq.offer(new int[]{s.charAt(i) - 'a', i});
        continue;
      }

      pq.poll();
    }

    List<int[]> lst = new ArrayList<>();
    while (!pq.isEmpty()) {
      lst.add(pq.poll());
    }

    lst.sort((o1, o2) -> o1[1] - o2[1]);
    StringBuilder sb = new StringBuilder();
    for (int[] arr : lst) {
      int n = arr[0];
      char c = (char) (n + 'a');
      sb.append(c);
    }


    return sb.toString();
  }
}
