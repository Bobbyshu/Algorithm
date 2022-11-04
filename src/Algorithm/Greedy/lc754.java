package Algorithm.Greedy;

/*
在一根无限长的数轴上，你站在0的位置。终点在target的位置。

你可以做一些数量的移动 numMoves :

每次你可以选择向左或向右移动。
第 i 次移动（从  i == 1 开始，到 i == numMoves ），在选择的方向上走 i 步。
给定整数 target ，返回 到达目标所需的 最小 移动次数(即最小 numMoves ) 。


 */
public class lc754 {
    public int reachNumber(int target) {
        int sum = 0, idx = 0;
        target = Math.abs(target);

        while (sum < target) {
            idx++;
            sum += idx;
        }

        if (sum == target) {
            return idx;
        }

        while ((target - sum) % 2 != 0) {
            idx++;
            sum += idx;
        }

        return idx;
    }
}
