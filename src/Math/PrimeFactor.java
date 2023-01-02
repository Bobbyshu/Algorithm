package Math;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {
//    public static void main(String[] args) {
//        dividePrimeFactor(15);
//    }
    public int smallestValue(int n) {
        int res = n;
        while (!isPrime(n)) {
            int temp = 0;
            for (int i = 2; i <= n; ++i) {
                if (n % i == 0) {
                    temp += i;
                    n /= i;
                    --i;
                }
            }
            n = temp;
            if (n == res) break;
            res = Math.min(res, n);
        }
        return res;
    }

    public boolean isPrime(int n) {
        if (n == 2)
            return true;
        if (n % 2 == 0)
            return false;

        int r = (int) Math.sqrt(n);
        for (int i = r; i > 2; i--) {
            if (n % i == 0) {
                return false;
            }
        }


        return true;
    }

    static public void dividePrimeFactor(int cur) {
        List<Integer> list = new ArrayList<>();
        while (cur > 1) {//质因数分解
            for (int i = 2; i <= cur; ++i) {
                if (cur % i == 0) {
                    cur = cur / i;
                    list.add(i);
                    break;
                }
            }
        }
        System.out.println(list);
    }
}

