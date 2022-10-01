package AIKeSiPiDia_OUEI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Complementary_Pair {
    public static long countComplement(List<String> list) {
        long ans = 0;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String cur = list.get(i);
            long temp = 0;
            for (int j = 0; j < cur.length(); j++) {
//                temp ^= (1 << (int) ())
            }
//            ans += map.getOrDefault(temp, 0)
        }

        return 0L;
    }
}
