package A_OUEI.addepar;

import java.util.List;

public class arrangeCoins {
    public static void arrangeCoins(List<Long> coins) {
        for (long item : coins) {
            long n = (long) Math.sqrt(1 + 8 * item - 1) / 2;
        }
    }
}
