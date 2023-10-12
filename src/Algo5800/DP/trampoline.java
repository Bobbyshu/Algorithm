package Algo5800.DP;

public class trampoline {
  public static void main(String[] args) {
    int[] t = {0, 3, 6, 9, 12};
    int[] d = {4, 8, 2, 1, 10};

//    int res = getMax(t, d);
    int res2 = get(t,d);
    System.out.println(res2);
  }
//  static int getMax(int[] t, int[] d) {
//    int n = t.length;
//
//    int[] dp = new int[n];
//
//    int res = 0;
//    for (int i = 0; i < n; ++i) {
//      int next = t[i] + d[i];
//      for (int j = 0; j < n; ++j) {
//        if (t[j] >= next) {
//          dp[j] = Math.max(dp[j], dp[i] + d[j]);
//        }
//      }
//    }
//    for (int i : dp) {
//      res = Math.max(i, res);
//    }
//
//    return res;
//  }

  static int get(int[] t, int[] d) {
    int n = t.length;

    int[] dp = new int[n];

    int res = 0;
    for (int i = 0; i < n; ++i) {
      dp[i] = d[i];
      for (int j = 0; j < i; ++j) {
        if (t[i] >= t[j] + d[j]) {
          dp[i] = Math.max(dp[i], dp[j] + d[i]);
        }
      }
      res = Math.max(res, dp[i]);
    }

    return res;
  }
}
