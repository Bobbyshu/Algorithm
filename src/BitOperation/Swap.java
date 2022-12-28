package BitOperation;

public class Swap {
    public void swapNumbers3(int a, int b) {
        // let first one be (a ^ b)
        // then let this one ^= other two
        a ^= b; // a = a ^ b
        b ^= a; // b = b ^ a ^ b = b ^ b ^ a = 0 ^ a = a
        a ^= b; // a = a ^ b ^ a = a ^ a ^ b = b ^ 0 = b
    }
}
