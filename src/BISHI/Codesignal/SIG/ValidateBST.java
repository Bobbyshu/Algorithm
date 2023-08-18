package BISHI.Codesignal.SIG;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {
    List<Integer> list;

    public boolean isValidBST(TreeNode root) {
        list = new ArrayList<>();
        dfs(root);

        for (int i = 0; i < list.size() - 1; ++i) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }

        return true;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
