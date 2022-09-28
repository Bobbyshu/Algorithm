package Cisco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cisco {

    public static void main(String[] args) {
        List<Integer> red = Arrays.asList(2,3,4);
        List<Integer> blue = Arrays.asList(3,1,1);
        int blueCost = 2;
        Cisco cisco = new Cisco();
        System.out.println(cisco.minimumCost(red, blue, blueCost));
    }

    List<Long> minimumCost(List<Integer> red, List<Integer> blue, int blueCost) {
        List<Long> res = new ArrayList<>();
        int m = red.size(), n = blue.size();
        boolean onBlue = false;
        int[][] dp = new int[m][n];

//        for (int j = 1; j <= m; j++) {
//            dp[0][j] = red.get(j - 1) + dp[0][j - 1];
//        }
//
//        for (int i = 1; i <= n; i++) {
//            dp[i][0] = blue.get(i - 1) + dp[0][i - 1];
//        }
//        dp[1][0] += blueCost;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (onBlue) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + dp[i - 1][j - 1];
                } else {

                }
                if (i == j) res.add((long) dp[i][j]);
            }
        }

        return res;
    }
}
