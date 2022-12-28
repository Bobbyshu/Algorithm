package BitOperation;
// return the quantity of 1 in 2-bit
public class HammingWeight {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            ++res;
            n &= n - 1;
        }
        return res;
    }
}
