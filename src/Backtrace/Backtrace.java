package Backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Backtrace {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    public List<List<Integer>> combine(int n, int k) {
        if (n > k) return new ArrayList<>();

        res = new ArrayList<>();
        path = new LinkedList<>();

        backtrace(n, k, 1);
        return res;
    }

    void backtrace(int n, int k, int startIndex) {
        //base case
        if (path.size() == k) {
            res.add(new LinkedList<>(path));
            return;
        }

        //for循环就是遍历集合区间，可以理解一个节点有多少个孩子，这个for循环就执行多少次。
        //for循环可以理解是横向遍历，backtracking（递归）就是纵向遍历
        //搜索叶子节点就是找的其中一个结果了
        //牢记剪枝代表的意义
        //如果for循环选择的起始位置之后的元素个数 已经不足 我们需要的元素个数了，那么就没有必要搜索了。
        //已经选择的元素个数：path.size();
        //还需要的元素个数为: k - path.size();
        //在集合n中至多要从该起始位置 : n - (k - path.size()) + 1，开始遍历
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtrace(n, k, i + 1);
            path.removeLast();
        }
    }
}

class sum {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        path = new LinkedList<>();

        backtrace(k, n, 1, 0);
        return res;
    }

    void backtrace(int k, int target, int startIndex, int sum) {
        if (sum > target) return;

        if (path.size() == k) {
            if (target == sum) res.add(new LinkedList<>(path));
            return;
        }

        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backtrace(k, target, i + 1, sum);
            sum -= i;
            path.removeLast();
        }
    }
}
