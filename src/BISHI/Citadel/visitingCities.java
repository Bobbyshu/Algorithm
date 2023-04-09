package BISHI.Citadel;

import java.util.ArrayList;
import java.util.List;

public class visitingCities {
  List<Long> minimumCost(List<Integer> red, List<Integer> blue, int blueCost) {
    int n = red.size();
    List<Long> res = new ArrayList<>();
    long[][] dp = new long[n + 1][2];
    dp[0][0] = 0;
    dp[0][1] = blueCost;
    res.add(0L);

    for (int i = 1; i <= n; ++i) {
      dp[i][0] = Math.min(dp[i - 1][0] + red.get(i - 1), dp[i - 1][1] + red.get(i - 1));
      dp[i][1] = Math.min(dp[i - 1][1] + blue.get(i - 1), dp[i - 1][0] + red.get(i - 1) + blueCost);
      res.add(Math.min(dp[i][1], dp[i][0]));
    }

    return res;
  }
}
