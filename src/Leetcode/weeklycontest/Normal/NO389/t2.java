package Leetcode.weeklycontest.Normal.NO389;

public class t2 {
    public long countSubstrings(String s, char c) {
        long cnt = 0L;

        for (char ch : s.toCharArray()) {
            if (ch == c) {
                ++cnt;
            }
        }

        // z z z z
        // z  -> 4
        // z *** z -> C(4,2)
        // n + n * (n - 1) / 2 = n * (n + 1) / 2
        return cnt * (cnt + 1) / 2;
    }
}
