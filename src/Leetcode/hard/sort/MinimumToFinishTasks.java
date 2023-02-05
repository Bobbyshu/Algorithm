package Leetcode.hard.sort;

import java.util.Arrays;

public class MinimumToFinishTasks {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (o1, o2) -> (o2[1] - o2[0]) - (o1[1] - o1[0]));
        // System.out.println(Arrays.deepToString(tasks));
        int p = 0, sum = 0;
        for (int[] t : tasks) {
            p = Math.max(p, sum + t[1]);
            sum += t[0];
        }
        return p;
    }
}
