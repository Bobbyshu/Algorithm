package DynamicProgramming.String;
/*
Given a string s, return the number of distinct non-empty subsequences of s.
Since the answer may be very large, return it modulo 109 + 7.

A subsequence of a string is a new string that is formed from the original string
by deleting some (can be none) of the characters without disturbing the
relative positions of the remaining characters.
(i.e., "ace" is a subsequence of "abcde" while "aec" is not.

 */
/*
根据题意我们设dp[i]为前i个字符可以组成的不同的子序列，则有

dp[i] = dp[i - 1] + newCount - repeatCount

其中newCount为加上s[i]后新增的子序列个数，repeatCount为重复的子序列个数

于是我们只需要计算newCount和repeatCount即可

newCount的值比较好计算，就是dp[i - 1]。

然后我们计算repeatCount，我们观察遍历到的第二个字符b，出现重复的序列为b和ab，
而这两个序列正好是上一次添加b（也就是第②步）的时候新增的两个序列。
于是我们可以使用数组preCount来记录上一次该字符新增的个数，该个数就是repeatCount。

由于dp[i]仅和dp[i-1]有关，我们可以滚动存储。

最后我们把空串减去即可。
 */
public class distinctSubsequencesII {
    public int distinctSubseqII(String s) {
        int mod = (int) 1e9 + 7;
        int n = s.length();
        //之前新增的个数
        int[] preCount = new int[26];
        int curAns = 1;
        char[] chs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            //新增的个数
            int newCount = curAns;
            //当前序列的个数 = 之前的 + 新增的 - 重复的
            curAns = ((curAns + newCount) % mod - preCount[chs[i] - 'a'] % mod + mod) % mod;
            //记录当前字符的 新增值
            preCount[chs[i] - 'a'] = newCount;
        }
        //减去空串
        return curAns - 1;
    }
}
