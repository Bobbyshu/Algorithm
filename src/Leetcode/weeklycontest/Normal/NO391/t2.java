package Leetcode.weeklycontest.Normal.NO391;

public class t2 {
    // 10 3
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int res = numBottles;
        // 此处要用>=，相等时也可以喝一瓶
        while (numBottles >= numExchange) {
            numBottles -= (numExchange - 1);
            ++numExchange;
            ++res;
        }

        return res;
    }
}
