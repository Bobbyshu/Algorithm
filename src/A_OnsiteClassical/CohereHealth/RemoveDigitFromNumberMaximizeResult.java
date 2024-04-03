package A_OnsiteClassical.CohereHealth;

public class RemoveDigitFromNumberMaximizeResult {
    // 多了负数，但思路一样
    // 我们从左至右遍历 number，如果遍历到 number[i]=digit，且 number[i]<number[i+1]（如果存在，下同)
    // 则我们删除该字符后得到的结果最大；
    //如果遍历完成依旧不存在满足上一个条件的下标，则我们删除 digit 出现的最后一个下标，此时删除该字符后得到的结果最大。
    public static void main(String[] args) {
        System.out.println(removeDigitEnumerate(15958, 5));
        System.out.println(removeDigitEnumerate(-5859, 5));
        System.out.println(removeDigitEnumerate(-5000, 5));
    }
    public static String removeDigit(String number, char digit) {

        int n = number.length(), removeIdx = -1;

        // 遍历数字的每一位
        for (int i = 0; i < n; i++) {
            if (number.charAt(i) == digit) { // 如果当前位是指定的数字 digit
                removeIdx = i; // 记录要移除的数字的索引
                if (i < n - 1 && number.charAt(i) < number.charAt(i + 1)) { // 如果下一位数字大于当前数字，则跳出循环
                    break;
                }
            }
        }

        if (removeIdx == n - 1) { // 如果要移除的数字在最后一位
            return number.substring(0, n - 1); // 返回移除最后一位后的字符串
        }

        // 返回移除指定数字后的结果字符串
        return number.substring(0, removeIdx) + number.substring(removeIdx + 1);

    }

    public static int removeDigitEnumerate(int num, int d) {
        int sign = 1;
        if (num < 0) {
            sign = -1;
        }
        String number;
        if (num > 0) {
            number = String.valueOf(num);
        } else {
            number = String.valueOf(-num);
        }

        char digit = (char) (d + '0');

//        String res = "";
        int max = Integer.MIN_VALUE;
        int n = number.length();
        for (int i = 0; i < n; i++) {
            if (number.charAt(i) == digit) {
                String newNumber = number.substring(0, i) + number.substring(i + 1);
                int cur = sign * Integer.parseInt(newNumber);
                if (cur > max) {
//                    res = newNumber;
                    max = cur;
                }
            }
        }

        return max == Integer.MIN_VALUE ? num : max;
    }
}
