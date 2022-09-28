package week_contest;

public class bit_transfer {
    //get the reverse string of i-bit
    private String getString(int n, int i) {
        StringBuffer sb = new StringBuffer();
        while (n != 0) {
            sb.append(n % i);
            n /= i;
        }
        return sb.toString();
    }
}
