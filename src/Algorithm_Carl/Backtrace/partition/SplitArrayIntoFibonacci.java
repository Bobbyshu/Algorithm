package Algorithm_Carl.Backtrace.partition;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayIntoFibonacci {
    public static void main(String[] args) {
        String s = "1101111";
        splitIntoFibonacci(s);
    }
    static List<Integer> res;
    static public List<Integer> splitIntoFibonacci(String num) {
        res = new ArrayList<>();
        backtrace(num.toCharArray(), 0);
        return res;
    }

    static boolean backtrace(char[] digit, int idx) {
        if (idx == digit.length && res.size() >= 3) {
            return true;
        }

        for (int i = idx; i < digit.length; ++i) {
            if (digit[idx] == '0' && i > idx) {
                break;
            }

            long num = subDigit(digit, idx, i + 1);
            if (num > Integer.MAX_VALUE) {
                break;
            }

            int size = res.size();
            //如果截取的数字大于res中前两个数字的和，说明这次截取的太大，直接终止，因为后面越截取越大
            if (size >= 2 && num > res.get(size - 1) + res.get(size - 2)) {
                break;
            }

            if (size <= 1 || num == res.get(size - 1) + res.get(size - 2)) {
                res.add((int) num);
                if (backtrace(digit, i + 1)) {
                    return true;
                }
                res.remove(res.size() - 1);
            }
        }

        return false;
    }

    static long subDigit(char[] digit, int start, int end) {
        long res = 0L;
        for (int i = start; i < end; ++i) {
            res = res * 10 + digit[i] - '0';
        }
        return res;
    }
}
