package yamaxun_ouei.former;

public class findBookMark010Or101 {
    public long numberOfWays(String s) {
//        n0 等于 s.substr(0,i)中 值为 "0" 的子序列的数量
//        n1 等于 s.substr(0,i)中 值为 "1" 的子序列的数量
//        n10 等于 s.substr(0,i)中 值为 "10" 的子序列的数量
//        n01 等于 s.substr(0,i)中 值为 "01" 的子序列的数量
        long ans = 0, n0 = 0, n1 = 0, n10 = 0, n01 = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                n01 += n0;
                n1++;
                ans += n10;
            } else {
                n10 += n1;
                n0++;
                ans += n01;
            }
        }
        return ans;
    }

    public long numberOfWay(String s) {
        // 中间扩散法:合法的字符组合自由010与101
        // 用两个数组存储s[i]前后的0与1的数目
        // 时间复杂度:O(N),空间复杂度:O(N)
        int len = s.length();
        int[] arr_0 = new int[len];
        int[] arr_1 = new int[len];
        arr_0[0] = s.charAt(0) == '0' ? 1 : 0;
        arr_1[0] = s.charAt(0) == '1' ? 1 : 0;
        int count_0 = arr_0[0];
        int count_1 = arr_1[0];
        for (int i = 1; i < len; i++) {
            arr_0[i] = s.charAt(i) == '0' ? ++count_0 : arr_0[i - 1];
            arr_1[i] = s.charAt(i) == '1' ? ++count_1 : arr_1[i - 1];
        }
        long res = 0;
        // 遍历中间的然后找两边的组合数
        for (int i = 1; i < len - 1; i++) {
            if(s.charAt(i) == '1') {
                res += (long) arr_0[i - 1] * (arr_0[len - 1] - arr_0[i - 1]);
            }else {
                res += (long) arr_1[i - 1] * (arr_1[len - 1]- arr_1[i - 1]);
            }
        }
        return res;
    }
}
