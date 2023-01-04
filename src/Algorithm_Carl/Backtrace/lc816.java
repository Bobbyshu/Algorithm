package Algorithm_Carl.Backtrace;

import java.util.ArrayList;
import java.util.List;

public class lc816 {
    public static void main(String[] args) {
        String s = "(00011)";
        ambiguousCoordinates(s);
    }
    static public List<String> ambiguousCoordinates(String s) {
        List<String> res = new ArrayList<>();
        s = s.substring(1, s.length() - 1);
        for (int i = 1; i < s.length(); i++) {
            for (String x : genNums(s.substring(0, i))) {
                for (String y : genNums(s.substring(i))) {
                    res.add("(" + x + ", " + y + ")");
                }
            }
        }
        return res;

    }

    static private List<String> genNums(String num) {
        List<String> list = new ArrayList<>();
        int i = 1;
        String left, right;
        while (i <= num.length()) {
            left = num.substring(0, i);
            right = num.substring(i++);
            //左边有前导0或者尾部有0就直接跳过
            //右边非空且右边一位为0就不行
            if (!left.equals("0") && left.charAt(0) == '0' ||
                    (!right.isEmpty() && right.charAt(right.length() - 1) == '0')) {
                continue;
            }

            //直接加一个整数
            if (right.isEmpty()) {
                list.add(left);
            } else {     //组合一个小数
                list.add(left + "." + right);
            }
//            list.add(left + "." + right);
        }
        return list;
    }
}
