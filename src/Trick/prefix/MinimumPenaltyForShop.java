package Trick.prefix;

public class MinimumPenaltyForShop {
    public int bestClosingTime(String s) {
        int n = s.length();
        int[] yes = new int[n + 1];
        int[] no = new int[n + 1];

        for (int i = n - 1; i >= 0; --i) {
            yes[i] = s.charAt(i) == 'Y' ? yes[i + 1] + 1 : yes[i + 1];
        }

        for (int i = 1; i <= n; ++i) {
            no[i] = s.charAt(i - 1) == 'N' ? no[i - 1] + 1 : no[i - 1];
        }

        int min = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i <= n; ++i) {
            int temp = yes[i] + no[i];
            if (temp < min) {
                min = temp;
                res = i;
            }
        }

        return res;
    }
}
