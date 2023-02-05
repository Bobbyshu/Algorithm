package Leetcode;

public class MaximizeDistanceClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int cnt1 = 0, cnt2 = 0;
        int i = 0, j = seats.length - 1;

        while (seats[i] == 0) {
            ++cnt1;
            ++i;
        }

        while (seats[j] == 0) {
            ++cnt2;
            --j;
        }

        int cntMid = 0, cntMax = 0;

        for (int k = i + 1; k <= j; ++k) {
            if (seats[k] == 0) {
                ++cntMid;
            } else {
                cntMax = Math.max(cntMax, cntMid);
                cntMid = 0;
            }
        }

        return Math.max(Math.max(cnt1, cnt2), (cntMax + 1) / 2);
    }
}
