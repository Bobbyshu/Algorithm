package String.Serialization;

import java.util.HashSet;
import java.util.Set;

public class ReorderedPowerOf2 {
    Set<String> set = new HashSet<>();
    public boolean reorderedPowerOf2(int n) {
        init();
        return set.contains(countDigits(n));
    }

    void init() {
        for (int i = 1; i <= 1e9; i <<= 1) {
            set.add(countDigits(i));
        }
    }

    String countDigits(int n) {
        char[] cnt = new char[10];
        while (n > 0) {
            ++cnt[n % 10];
            n /= 10;
        }
        return new String(cnt);
    }
}
