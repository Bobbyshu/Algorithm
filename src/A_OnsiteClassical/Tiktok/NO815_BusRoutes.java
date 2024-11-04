package A_OnsiteClassical.Tiktok;

import java.util.*;

public class NO815_BusRoutes {
  public int numBusesToDestination(int[][] routes, int source, int target) {
    if (source == target) {
      return 0;
    }
    // 记录某个车站可以进入的路线
    Map<Integer, Set<Integer>> map = new HashMap<>();
    // 队列存的是经过的路线
    Deque<Integer> q = new ArrayDeque<>();
    // 哈希表记录的进入该路线所使用的距离
    Map<Integer, Integer> dist = new HashMap<>();

    int n = routes.length;
    for (int i = 0; i < n; ++i) {
      for (int station : routes[i]) {
        if (station == source) {
          q.addLast(i);
          dist.put(i, 1);
        }

        Set<Integer> set = map.getOrDefault(station, new HashSet<>());
        set.add(i);
        map.put(station, set);
      }
    }

    while (!q.isEmpty()) {
      // 取出当前所在的路线，与进入该路线所花费的距离
      int curRoute = q.pollFirst();
      int step = dist.get(curRoute);

      // 遍历该路线所包含的车站
      for (int station : routes[curRoute]) {
        if (station == target) {
          return step;
        }

        Set<Integer> lines = map.get(station);
        if (lines.isEmpty()) {
          continue;
        }

        for (int next : lines) {
          if (!dist.containsKey(next)) {
            dist.put(next, step + 1);
            q.addLast(next);
          }
        }
      }
    }

    return -1;
  }
}
