package Trick;


public class bitPalindrome {
    /*
    判断出现奇数次的字符最多只有一个（该字符将会出现在中点位置）。全体字符有128个，可以用高低两个
    long 类型的位图表示128位。通过将 1L 左移，例如 'A' 的 ASCII 值为65，就向左移动65位.
    所以位图的从第0位向左数第65位表示 'A'，以此类推。0 ~ 63 放在低位，64 ~ 127 放在高位。
    如果是0与1异或是1：0 ^ 1= 1，1再与1异或又变回0：1 ^ 1 = 0，所以0代表该位上得字符出现偶数次。
    最后利用Long.bitCount()统计一下1的数量，是否小于等于1，即是否最多只有1个字符出现奇数次。*/
    public boolean canPermutePalindrome(String s) {
        long highBitmap = 0;
        long lowBitmap = 0;
        for (char ch : s.toCharArray()) {
            if (ch >= 64) {
                highBitmap ^= 1L << ch - 64;
            } else {
                lowBitmap ^= 1L << ch;
            }
        }
        return Long.bitCount(highBitmap) + Long.bitCount(lowBitmap) <= 1;
    }
}
