package A_OnsiteClassical.Tree;

// 求平衡二叉树
//public class BalancedTree {
//    public boolean isBalanced(TreeNode root) {
//        return dfs(root) != -1;
//    }
//
//
//    public int dfs(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        int left = dfs(root.left);
//        if (left == -1) {
//            return -1;
//        }
//        int right = dfs(root.right);
//        if (right == -1) {
//            return -1;
//        }
//
//        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
//    }

//public boolean isBalanced(TreeNode root) {
//    if (root == null) return true;
//    return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
//}
//
//private int depth(TreeNode root) {
//    if (root == null) return 0;
//    return Math.max(depth(root.left), depth(root.right)) + 1;
//}

//
//}
