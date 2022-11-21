package Math;

public class largestCommonMultiple {
    public int gcd(int b, int a) {
        return a != 0 ? gcd(a, b % a) : b;
    }

    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
