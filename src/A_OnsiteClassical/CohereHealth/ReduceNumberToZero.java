package A_OnsiteClassical.CohereHealth;

@SuppressWarnings("LanguageDetectionInspection")
public class ReduceNumberToZero {
    // 1342
    // 判断n=0
    //目的是使得最终结果的二进制表示均为 000，两种操作对二进制数的影响分别为「整体右移」和「消减最低位的 111」。
    //因此整个模拟过程其实是：如果当前的 num 最低位不为 1（偶数），则不断进行右移，直到最低位为 1（奇数），
    // 然后再对最低位的 1 进行消减，直到二进制表示中的所有 1 均被消减完（结果为 0），模拟过程结束。
    //换句话说，总的操作次数为 = 右移次数 + 消减次数 ：

    //右移次数：num 中最高位 1 的所在的位置；
    //消减次数：num 中 1 的个数。
    public static void main(String[] args) {
        String s = "1110";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 400000; ++i) {
            sb.append('1');
        }
        System.out.println(numberOfStepsDigit(sb.toString()));
        System.out.println(leftOne(s));
        System.out.println(getOne(s));
        System.out.println(Integer.parseInt("011100", 2));
    }
    public static int numberOfStepsDigit(String s) {
        int one = getOne(s);
        if (one == 0) {
            return 0;
        }

        int leftMost = leftOne(s);

        return leftMost + one - 1;
    }

    public static int leftOne(String s) {
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '1') {
                return n - i;
            }
        }
        return -1;
    }

    public static int getOne(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                cnt++;
            }
        }
        return cnt;
    }

    public int numberOfSteps(int num) {
        String s = "011100";
        StringBuilder sb = new StringBuilder();
        int idx = -1;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                continue;
            } else {
                idx = i;
            }
        }

        for (int i = idx; i < s.length(); ++i) {
            sb.append(s.charAt(i));
        }

        int n = Integer.parseInt(sb.toString(), 2);

        int res = 0;
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                --n;
            }
            ++res;
        }

        return res;
    }
}
