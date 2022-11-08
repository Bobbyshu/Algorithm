package A_OUEI.TuSimple;

import java.util.*;

public class bestSumAnyTreePath {
    static int bestPath = Integer.MIN_VALUE;

    public static int bestSumDownwardTreePath(List<Integer> parent, List<Integer> values) {

        if (parent.size() == 1) return values.get(0);

        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 1; i < parent.size(); i++) {
            List<Integer> temp = tree.getOrDefault(parent.get(i), null);
            if (temp == null) {
                temp = new ArrayList<>();
                temp.add(i);
                tree.put(parent.get(i), temp);
            } else {
                temp.add(i);
            }
        }

        findBestSum(parent, values, tree, 0, 0);

        return bestPath;

    }

    public static void findBestSum(List<Integer> parent, List<Integer> values,
                                   Map<Integer, List<Integer>> tree, int root, int sum) {


        sum = sum + values.get(root);
        bestPath = Math.max(bestPath, sum);
        sum = Math.max(0, sum);

        if (tree.get(root) == null) return;

        for (Integer child : tree.get(root)) {
            findBestSum(parent, values, tree, child, sum);
        }

    }


}
