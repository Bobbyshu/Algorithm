package Algorithm_Carl.Backtrace;

public class ClosestDessertCost {
  // brute force : 10 * 3^10
    int res = Integer.MAX_VALUE;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
      for (int b : baseCosts) {
        res = Math.min(b, res);
      }

      for (int b : baseCosts) {
        dfs(toppingCosts, 0, b, target);
      }

      return res;
    }

    void dfs(int[] top, int i, int curCost, int target) {
      // 当前方案成本价已经大于等于我们已有最优方案的差值，后续选择只会使得成本更大，与target的差值更大
      // 我们可以停止继续往下搜索，及时回溯。
      if (Math.abs(res - target) < curCost - target) {
        return;
      }
      // 当前方案成本价与target的差值 小于等于 我们已有最优方案的与target的差值
      // if不能直接return，因为可能继续curCost < target，再选择基料后，更加接近target
      if (Math.abs(res - target) >=  Math.abs(curCost - target)) {
        // 如果当前方案成本更接近target，那么更新最优方案为当前方案
        if (Math.abs(res - target) > Math.abs(curCost - target)) {
          res = curCost;
        } else {   // 如果当前方案成本与已有方案同样接近target，那么选择其中更小的成本值
          res = Math.min(res, curCost);
        }
      }

      if (i == top.length) {
        return;
      }

      dfs(top, i + 1, curCost + top[i] * 2, target);
      dfs(top, i + 1, curCost + top[i], target);
      dfs(top, i + 1, curCost, target);
    }
}
