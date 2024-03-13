package Leetcode.weeklycontest.DOUBLE.NO124;

import java.util.Arrays;

public class T3 {

    int[][] memo;

    public int maxOperations(int[] nums) {
        int n = nums.length;
        memo = new int[n][n];
        for (int[] r : memo) {
            Arrays.fill(r, -1);
        }
        int first = dfs(nums, 2, n - 1, nums[0] + nums[1]);
        for (int[] r : memo) {
            Arrays.fill(r, -1);
        }
        int second = dfs(nums, 0, n - 3, nums[n - 1] + nums[n - 2]);
        for (int[] r : memo) {
            Arrays.fill(r, -1);
        }
        int third = dfs(nums, 1, n - 2, nums[0] + nums[n - 1]);
        return Math.max(first, Math.max(second, third)) + 1;
    }

    private int dfs(int[] nums, int i, int j, int cur) {
        if (i >= j) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int res = 0;
        if (nums[i] + nums[i + 1] == cur) {
            res = Math.max(res, dfs(nums, i + 2, j, cur) + 1);
        }

        if (nums[j] + nums[j - 1] == cur) {
            res = Math.max(res, dfs(nums, i, j - 2, cur) + 1);
        }

        if (nums[i] + nums[j] == cur) {
            res = Math.max(res, dfs(nums, i + 1, j - 1, cur) + 1);
        }

        memo[i][j] = res;
        return memo[i][j];
    }

}
