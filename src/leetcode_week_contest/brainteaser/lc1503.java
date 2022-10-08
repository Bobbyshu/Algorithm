package leetcode_week_contest.brainteaser;
/*
We have a wooden plank of the length n units. Some ants are walking on the plank,
each ant moves with a speed of 1 unit per second.
Some ants move to the left, the other move to the right.
When two ants moving in two different directions meet at some point,
they change their directions and continue moving again.
Assume changing directions does not take any additional time.
When an ant reaches one end of the plank at a time t, it falls out of the plank immediately.
Given an integer n and two integer arrays left and right,
the positions of the ants moving to the left and the right,
return the moment when the last ant(s) fall out of the plank.
两个蚂蚁相撞之后会互相调头，如果每只蚂蚁都长得一模一样
那么蚂蚁碰撞的调头就等于穿透了 => 求单只最晚落地的蚂蚁 与碰撞无关
 */

public class lc1503 {
    public int getLastMoment(int n, int[] left, int[] right) {
        int res = 0;
        for (int ant : left) {
            res = Math.max(res, ant);
        }

        for (int ant : right) {
            res = Math.max(res, n - ant);
        }

        return res;
    }
}
