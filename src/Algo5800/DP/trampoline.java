package Algo5800.DP;

import java.util.Arrays;

public class trampoline {
  public static void main(String[] args) {
    int[] t = {0, 3, 6, 9, 12};
    int[] d = {4, 8, 2, 1, 10};

    int res = getMax(t, d);
//    int res2 = get(t,d);
    System.out.println(res);
//    System.out.println(res2);
  }

  static int getMax(int[] t, int[] d) {
    int n = t.length;

    int[] dp = new int[n];

    int res = 0;
    dp[n - 1] = d[n - 1];
    for (int i = n - 2; i >= 0; --i) {
      int next = t[i] + d[i];
      for (int j = i + 1; j < n; ++j) {
        if (t[j] >= next) {
          dp[i] = Math.max(dp[i + 1], d[i] + dp[j]);
          break;
        }
      }
    }

    System.out.println(Arrays.toString(dp));
    for (int i : dp) {
      res = Math.max(i, res);
    }

    return res;
  }

//  static int get(int[] t, int[] d) {
//    int n = t.length;
//
//    int[] dp = new int[n];
//
//    int res = 0;
//    for (int i = 0; i < n; ++i) {
//      dp[i] = d[i];
//      for (int j = 0; j < i; ++j) {
//        if (t[i] >= t[j] + d[j]) {
//          dp[i] = Math.max(dp[i], dp[j] + d[i]);
//        }
//      }
//      res = Math.max(res, dp[i]);
//    }
//
//    System.out.println(Arrays.toString(dp));
//    return res;
//  }

  static int getMaxAirtimeWithLimitedJumps(int[] t, int[] d, int k) {
    int n = t.length;

    // 使用两维数组 dp[i][j] 来表示在第 i 个蹦床处，使用了 j 次跳跃时的最大空中飞行距离
    int[][] dp = new int[n][k + 1];

    int res = 0;
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j <= k; ++j) {
        dp[i][j] = d[i];  // 如果跳跃到第 i 个蹦床，获得的空中飞行距离为 d[i]

        for (int x = 0; x < i; ++x) {
          if (t[i] >= t[x] + d[x] && j > 0) {
            dp[i][j] = Math.max(dp[i][j], dp[x][j - 1] + d[i]);
          }
        }

        res = Math.max(res, dp[i][j]);
      }
    }

    return res;
  }

}
