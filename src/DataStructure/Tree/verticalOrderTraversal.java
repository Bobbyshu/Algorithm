package DataStructure.Tree;

import java.util.*;

public class verticalOrderTraversal {
    Map<TreeNode, int[]> map = new HashMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map.put(root, new int[]{0, 0, root.val});
        dfs(root);

        List<int[]> list = new ArrayList<>(map.values());
        list.sort((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }

            if (a[1] != b[1]) {
                return a[1] - b[1];
            }

            return a[2] - b[2];
        });

        int n = list.size();
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; ) {
            int j = i;
            List<Integer> temp = new ArrayList<>();
            while (j < n && list.get(j)[0] == list.get(i)[0]) {
                temp.add(list.get(j)[2]);
                j++;
            }

            res.add(temp);
            i = j;
        }

        return res;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        int[] info = map.get(root);
        int col = info[0], row = info[1];

        if (root.left != null) {
            map.put(root.left, new int[]{col - 1, row + 1, root.left.val});
            dfs(root.left);
        }

        if (root.right != null) {
            map.put(root.right, new int[]{col + 1, row + 1, root.right.val});
            dfs(root.right);
        }
    }
}
