package Leetcode.weeklycontest.DOUBLE.NO121;

import java.util.*;

public class T3 {
  public int minimumOperationsToMakeEqual(int x, int y) {
    if (x <= y) {
      return y - x;
    }

    int res = x - y;
    Set<Integer> visited = new HashSet<>();
    List<Integer> q =  new ArrayList<>();
    q.add(x);
    visited.add(x);

    int step = 0;
    while (true) {
      // 用两个list防止线程出问题
      List<Integer> temp = q;
      q = new ArrayList<>();

      // 检索之前的
      for (int v : temp) {
        if (v == y) {
          return Math.min(res, step);
        }

        if (v < y) {
          res = Math.min(res, step + y - v);
          continue;
        }

        if (v % 11 == 0 && !visited.contains(v / 11)) {
          visited.add(v / 11);
          q.add(v / 11);
        }

        if (v % 5 == 0 && !visited.contains(v / 5)) {
          visited.add(v / 5);
          q.add(v / 5);
        }

        if (!visited.contains(v - 1)) {
          visited.add(v - 1);
          q.add(v - 1);
        }

        if (!visited.contains(v + 1)) {
          visited.add(v + 1);
          q.add(v + 1);
        }
      }

      ++step;
    }
  }
}
