package A_OnsiteClassical.grind75;

public class KthSmallestElementBST {
  public static void main(String[] args) {
    KthSmallestElementBST kthSmallestElementBST = new KthSmallestElementBST();
    TreeNode root = new TreeNode(3);
    TreeNode first = new TreeNode(1);
    TreeNode second = new TreeNode(2);
    TreeNode four = new TreeNode(4);
    root.left = first;
    root.right = four;
    first.right = second;
    kthSmallestElementBST.kthSmallest(root, 0);
  }
  int cur = 0;
  int res = -1;
  int k;
  public int kthSmallest(TreeNode root, int k) {
    this.k = k;
    dfs(root);
    return res;
  }

  private void dfs(TreeNode root) {
    if (root == null) {
      return;
    }

    dfs(root.left);
    if (cur == k - 1) {
      res = root.val;
    }
    cur++;
    dfs(root.right);
  }
}
