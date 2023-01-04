package Algorithm_Carl.Backtrace;

import java.util.ArrayList;
import java.util.List;

public class lc784 {
    List<String> res;
    public List<String> letterCasePermutation(String s) {
        res = new ArrayList<>();
        char[] charArray = s.toCharArray();
        dfs(charArray, 0);

        return res;
    }

    private void dfs(char[] charArray, int i) {
        if (i == charArray.length) {
            res.add(new String(charArray));
            return;
        }

        if(charArray[i] >= '0' && charArray[i] <= '9'){
            dfs(charArray, i + 1);
            return;
        }

        charArray[i] = Character.toLowerCase(charArray[i]);
        dfs(charArray, i + 1);
        charArray[i] = Character.toUpperCase(charArray[i]);
        dfs(charArray, i + 1);
    }
}
