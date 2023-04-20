package Leetcode.weeklycontest.DOUBLE.NO102;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class t3 {
  public TreeNode replaceValueInTree(TreeNode root) {
    int len = 0;
    Map<Integer, Integer> mp = new HashMap<>();

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    mp.put(0, root.val);
    Map<TreeNode, TreeNode> par = new HashMap<>();
    while (!q.isEmpty()) {
      len++;
      int sz = q.size();
      for (int i = 0; i < sz; i++) {
        TreeNode n = q.poll();
        if (n.left != null) {
          q.add(n.left);
          mp.put(len, mp.getOrDefault(len, 0) + n.left.val);
        }
        if (n.right != null) {
          q.add(n.right);
          mp.put(len, mp.getOrDefault(len, 0) + n.right.val);
        }
      }
    }
    q.add(root);
    len = 0;
    root.val = 0;

    while (!q.isEmpty()) {
      len++;
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode cur = q.poll();
        int left = 0;
        int right = 0;
        if (cur.left != null) {
          left = cur.left.val;
        }
        if (cur.right != null) {
          right = cur.right.val;
        }
        if (cur.left != null) {
          q.add(cur.left);
          cur.left.val = mp.get(len) - left - right;
        }
        if (cur.right != null) {
          q.add(cur.right);
          cur.right.val = mp.get(len) - left - right;
        }
      }
    }
    return root;
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
}
