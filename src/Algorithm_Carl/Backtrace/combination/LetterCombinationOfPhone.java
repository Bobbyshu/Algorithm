package Algorithm_Carl.Backtrace.combination;

import java.util.ArrayList;
import java.util.List;
/*
这里for循环，可不像是在回溯算法：求组合问题和回溯算法：求组合总和中从startIndex开始遍历的。
因为本题每一个数字代表的是不同集合，也就是求不同集合之间的组合，
而回溯算法：求组合问题和回溯算法：求组合总和都是是求同一个集合中的组合！
 */
public class LetterCombinationOfPhone {
    List<String> res;
    StringBuilder path;
    String[] str = {"", "", "abc", "def", "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return new ArrayList<>();

        res = new ArrayList<>();
        path = new StringBuilder();

        backtrace(digits.toCharArray(), 0);
        return res;
    }
    //idx symbolize the location for char in current set
    void backtrace(char[] ch, int idx) {
        if (path.length() == ch.length) {
            res.add(path.toString());
            return;
        }

        String s = str[ch[idx] - '0'];
        for (int i = 0; i < s.length(); ++i) {
            path.append(s.charAt(i));
            backtrace(ch, idx + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
