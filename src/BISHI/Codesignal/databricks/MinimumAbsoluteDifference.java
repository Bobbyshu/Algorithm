package BISHI.Codesignal.databricks;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MinimumAbsoluteDifference {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int n = nums.size();
        int res = Integer.MAX_VALUE;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = x; i < n; i++) {
            int pre = nums.get(i - x);
            treeSet.add(pre);

            int k = nums.get(i);
            Integer right = treeSet.ceiling(k);
            if (null != right) {
                res = Math.min(res, Math.abs(right - k));
            }

            Integer left = treeSet.floor(k);
            if (null != left) {
                res = Math.min(res, Math.abs(left - k));
            }
        }

        return res;
    }
}
