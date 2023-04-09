package BISHI.Citadel;

import java.util.Collections;
import java.util.List;

public class shrinkingNumberLine {
  int shrinking(List<Integer> point, int k) {
    int n = point.size();

    Collections.sort(point);

    long ans = point.get(n - 1) - point.get(0);

    for (int i = 0; i < n; i++) {
      long tempMin = Math.min(point.get(0) + k, point.get(i) - k);
      long tempMax = Math.max(point.get(i) + k, point.get(n - 1) - k);
      long diff = tempMax - tempMin;
      ans = Math.min(ans, tempMax - tempMin);
    }
    return (int) ans;
  }
}
