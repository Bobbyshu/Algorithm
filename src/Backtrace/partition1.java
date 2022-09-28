package Backtrace;

import java.util.ArrayList;
import java.util.List;

public class partition1 {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    boolean[][] dp;

    public List<List<String>> partition(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        // 预处理
        dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = true;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = (arr[i] == arr[j] && dp[i + 1][j - 1]);
            }
        }
        dfs(s, n, 0);
        // List<List<String>> 转 String[][]，这里不重要
//        String[][] ans = new String[res.size()][];
//        for (int i = 0; i < res.size(); i++) {
//            ans[i] = new String[res.get(i).size()];
//            for (int j = 0; j < ans[i].length; j++) {
//                ans[i][j] = res.get(i).get(j);
//            }
//        }
        return res;
    }

    public void dfs(String s, int n, int pos) {
        if (pos == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = pos; i < n; i++) {
            // s[pos:i] （闭区间）是一个回文，所以递归搜索s[i+1, s.length()-1]
            if (dp[pos][i]) {
                path.add(s.substring(pos, i + 1));
                dfs(s, n, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
