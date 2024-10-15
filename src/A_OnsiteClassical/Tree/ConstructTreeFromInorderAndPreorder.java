package A_OnsiteClassical.Tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromInorderAndPreorder {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> valToId = new HashMap<>();
    for (int i = 0; i < inorder.length; ++i) {
      valToId.put(inorder[i], i);
    }

    return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, valToId);
  }

  private TreeNode build(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight, Map<Integer, Integer> valToId) {
    if (preLeft > preRight || inLeft > inRight) {
      return null;
    }

    int pivot = preorder[preLeft];
    int idx = valToId.get(pivot);
    // 3 9 20 15 7 pivot = 3 => idx = 1
    // left part = preLeft + leftsize = preLeft + idx - preLeft

    // 9 3 15 20 7
    // left size = idx - inLeft
    TreeNode root = new TreeNode(pivot);
    root.left = build(preorder, preLeft + 1, preLeft + idx - inLeft, inorder, inLeft, idx - 1, valToId);
    root.right = build(preorder, preLeft + idx - inLeft + 1, preRight, inorder, idx + 1, inRight, valToId);

    return root;
  }
}
