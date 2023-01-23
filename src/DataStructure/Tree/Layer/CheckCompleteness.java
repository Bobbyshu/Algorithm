package DataStructure.Tree.Layer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class CheckCompleteness {
  //对于一个完全二叉树，层序遍历的过程中遇到第一个空节点之后不应该再出现非空节点
  public boolean isCompleteTree(TreeNode root) {
    if (root == null) {
      return true;
    }

    Deque<TreeNode> queue = new LinkedList<>();
    TreeNode pre = root;
    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; ++i) {
        TreeNode cur = queue.poll();
        // for layer traverse, if any node meet null pre node
        // which means that the binary tree is no completed
        if (pre == null && cur != null) {
          return false;
        }
        if (cur.left != null) {
          queue.add(cur.left);
        }
        if (cur.right != null) {
          queue.add(cur.right);
        }
        pre = cur;
      }

    }
    return true;
  }
}
