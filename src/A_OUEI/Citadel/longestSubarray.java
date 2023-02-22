package A_OUEI.Citadel;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class longestSubarray {
  int maxLength(List<Integer> a, int k) {
    int sum = 0, cnt = 0, res = 0;
    for (int i = 0; i < a.size(); ++i) {
      if (sum + a.get(i) <= k) {
        sum += a.get(i);
        cnt++;
      } else {
        if (sum != 0) {
          sum = sum - a.get(i - cnt) + a.get(i);
        }
      }
      res = Math.max(res, cnt);
    }
    return res;
  }
}
