package A_OnsiteClassical.Tiktok;

import java.util.ArrayDeque;
import java.util.Deque;

public class NO735_AsteroidCollision {
  public int[] asteroidCollision(int[] asteroids) {
    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i < asteroids.length; ++i) {
      if (stack.isEmpty() || asteroids[i] > 0 || stack.peekLast() < 0) {
        stack.addLast(asteroids[i]);
      } else if (stack.peekLast() <= -asteroids[i]) {
        if (stack.pollLast() < -asteroids[i]) {
          --i;
          continue;
        }
      }
    }

    int[] res = new int[stack.size()];
    for (int j = 0; j < res.length; j++) {
      res[j] = stack.pollFirst();
    }
    return res;
  }
}
