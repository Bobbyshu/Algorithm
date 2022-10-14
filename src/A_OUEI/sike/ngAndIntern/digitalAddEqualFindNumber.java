package A_OUEI.sike.ngAndIntern;

public class digitalAddEqualFindNumber {
    public static void main(String[] args) {
        System.out.println(digitSum(20, 5));
    }
    static int digitSum(int x, int y) {
        int res = 0;
        for (int i = 0; i <= x; i++) {
            if (sum(i) == y) {
                res++;
            }
        }
        return res;
    }

    static int sum(int x) {
        int res = 0;
        while (x > 0) {
            res += x % 10;
            x /= 10;
        }

        return res;
    }
}
