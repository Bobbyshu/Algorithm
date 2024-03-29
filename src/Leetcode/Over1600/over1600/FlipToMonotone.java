package Leetcode.Over1600.over1600;

public class FlipToMonotone {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] preOne = new int[n], backZero = new int[n];

        preOne[0] = s.charAt(0) == '1' ? 1 : 0;
        for (int i = 1; i < n; ++i) {
            if (s.charAt(i) == '1') {
                preOne[i] = preOne[i - 1] + 1;
            } else {
                preOne[i] = preOne[i - 1];
            }
        }

        backZero[n - 1] = s.charAt(n - 1) == '0' ? 1 : 0;
        for (int i = n - 2; i >= 0; --i) {
            if (s.charAt(i) == '0') {
                backZero[i] = backZero[i + 1] + 1;
            } else {
                backZero[i] = backZero[i + 1];
            }
        }

        // "00011000"
        // preOne = [0, 0, 0, 1, 2, 2, 2, 2]
        // backZero = [6, 5, 4, 3, 3, 3, 2, 1]

        // allOne = preOne[n - 1]
        // allZero = backZero[0]

        // -1 because allOne and allZero both include i
        // So we need to delete redundancy 1
        // between = Min(preOne[i] + backZero[i] - 1) (1 < i < n - 2)

        int res = Math.min(preOne[n - 1], backZero[0]);
        for (int i = 1; i < n - 1; ++i) {

            res = Math.min(res, preOne[i] + backZero[i] - 1);
        }

        return res;
    }
}
