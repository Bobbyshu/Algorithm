package Leetcode.weeklycontest.NO327;

public class t1 {
    public static void main(String[] args) {

    }

    public int maximumCount(int[] nums) {
        int neg = 0, pos = 0;
        for (int n : nums) {
            if (n < 0) {
                ++neg;
            } else if (n > 0) {
                ++pos;
            }
        }
        return Math.max(neg, pos);
    }
}
