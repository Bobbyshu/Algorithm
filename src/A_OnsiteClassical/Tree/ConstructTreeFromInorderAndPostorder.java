package A_OnsiteClassical.Tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromInorderAndPostorder {
  Map<Integer, Integer> map;

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    map = new HashMap<>();
    for (int i = 0; i < inorder.length; ++i) {
      map.put(inorder[i], i);
    }
    return dfs(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
  }

  private TreeNode dfs(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
    if (inLeft > inRight || postLeft > postRight) {
      return null;
    }

    int pivotVal = postorder[postRight];
    int idx = map.get(pivotVal);
    TreeNode root = new TreeNode(pivotVal);

    root.left = dfs(inorder, inLeft, idx - 1, postorder, postLeft, postLeft + idx - inLeft - 1);
    root.right = dfs(inorder, idx + 1, inRight, postorder, postLeft + idx - inLeft, postRight - 1);

    return root;
  }
}
