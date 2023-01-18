package BitManipulation;

public class HammingDistance {
    int getCnt(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            ++res;
        }
        return res;
    }

    int hammingDistance(int x, int y) {
        return getCnt(x ^ y);
    }
}
