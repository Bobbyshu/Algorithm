package A_OnsiteClassical.Tree;

import A_OnsiteClassical.grind75.TreeNode;

public class SubtreeOfAnotherTree {
  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null) {
      return subRoot == null;
    }
    if (subRoot == null) {
      return true;
    }

    boolean checkLeft = isSubtree(root.left, subRoot);
    boolean checkRight = isSubtree(root.right, subRoot);

    return checkLeft || checkRight || isSame(root, subRoot);
  }

  private boolean isSame(TreeNode r, TreeNode s) {
    if (r == null) {
      return s == null;
    }

    if (s == null) {
      return false;
    }

    if (s.val != r.val) {
      return false;
    }

    return isSame(r.left, s.left) && isSame(r.right, s.right);
  }
}
