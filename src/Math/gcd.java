package Math;

public class gcd {
    int gcd1(int a, int b) {
        return b == 0 ? a : gcd1(b, a % b);
    }

    int gcd2(int a, int b) {
        while (b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }

}
