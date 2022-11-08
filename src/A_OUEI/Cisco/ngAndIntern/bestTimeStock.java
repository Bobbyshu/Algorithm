package A_OUEI.Cisco.ngAndIntern;

public class bestTimeStock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2)
            return 0;

        int res = 0, pre = 0;
        for (int i = 1; i < n; i++) {
            int diff = prices[i] - prices[i - 1];
            pre = Math.max(pre + diff, 0);
            res = Math.max(res, pre);
        }

        return res;
    }
}
