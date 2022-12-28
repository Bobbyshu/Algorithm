package Trick;

public class swap {
    public void swapNumbers(int a, int b) {
        a -= b;
        b = a + b;
        a = b - a;
    }

    public void swapNumbers2(int a, int b) {
        a += b;
        b = a - b;
        a -= b;
    }


    /*
    b ^ a ^ b = a
    a ^ b ^ a = b

    a ^ a = 0
    0 ^ a = a
     */
    public void swapNumbers3(int a, int b) {
        // let first one be (a ^ b)
        // then let this one ^= other two
        a ^= b; // a = a ^ b
        b ^= a; // b = b ^ a ^ b = b ^ b ^ a = 0 ^ a = a
        a ^= b; // a = a ^ b ^ a = a ^ a ^ b = b ^ 0 = b
    }
}

