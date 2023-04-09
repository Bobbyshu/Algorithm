package Trick;

public class bit_transfer {
    //get the reverse string of i-bit
    private String getString(int n, int i) {
        if (n == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n % i);
            n /= i;
        }
        return sb.reverse().toString();
    }
}
