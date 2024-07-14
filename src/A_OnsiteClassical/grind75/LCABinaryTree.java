package A_OnsiteClassical.grind75;

public class LCABinaryTree {
  /**
   * There are four statement for us to find the LCA
   *  pq in different side
   *  pq in same side
   *  p is root
   *  q is root
   *  3 and 4 will return root directly
   *  for 1 and 2 we need to search it and return the result back
   *  by using post order traverse
   *  manipulation should be after traverse
   * @param root
   * @param p
   * @param q
   * @return LCA
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) { //base case
      return root;
    }

    if (root == p || root == q) { //find one
      return root;
    }

    // find p or q in left subtree
    TreeNode left=lowestCommonAncestor(root.left,p,q);
    // find p or q in right subtree
    TreeNode right=lowestCommonAncestor(root.right,p,q);

    // find out the target node
    if (left != null && right != null) {
      return root;
    }

    // only left have p or q
    if (left != null) {
      // keep searching left subtree
      // p and q must all in left subtree
      return left;
    }

    // only right have p or q
    if (right != null) {
      // keep searching right subtree
      // p and q must all in right subtree
      return right;
    }

    // which means we can't find lca
    // but context said that we must find the answer
    return null;
  }
}
