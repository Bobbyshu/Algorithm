package A_OnsiteClassical.Tree;

public class MinDepth {
    // 强调是到叶子节点，所以如果一边为空则不能算到了
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        if (root.left == null) {
            return minDepth(root.right) + 1;
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
