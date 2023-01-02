package Algorithm.Backtrace.combination;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        backtrace(n, k, 1);
        return res;
    }

    void backtrace(int n, int k, int startIndex) {
        if (path.size() == k && n == 0) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; ++i) {
            if (i > n)
                break;
            path.add(i);
            backtrace(n - i, k, i + 1);
            path.removeLast();
        }
    }
}
