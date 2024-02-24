package GuCheng.Fundmental.Algo.BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
  List<Integer> list;

  public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
    list = new ArrayList<>();
    dfs(root);
    List<List<Integer>> res = new ArrayList<>();
    int n = list.size();
    int min = list.get(0), max = list.get(n - 1);

    for (int q : queries) {
      List<Integer> cur = new ArrayList<>();
      if (q > max) {
        cur.add(max);
        cur.add(-1);
        res.add(cur);
        continue;
      } else if (q < min) {
        cur.add(-1);
        cur.add(min);
        res.add(cur);
        continue;
      }

      // make sure can find
      int idx = left_bound(list, q);
      int num = list.get(idx);
      int pre = -1, next = num;
      // 找到
      if (num == q) {
        pre = num;
      } else {
        pre = list.get(idx - 1);
      }

      cur.add(pre);
      cur.add(next);
      res.add(cur);
    }

    return res;
  }

  private void dfs(TreeNode root) {
    if (root == null) {
      return;
    }

    dfs(root.left);
    list.add(root.val);
    dfs(root.right);
  }

  private int left_bound(List<Integer> arr, int target) {
    int l = 0, r = arr.size() - 1;

    while (l < r) {
      int mid = (l + r) / 2;
      if (arr.get(mid) >= target) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }

    // return arr.get(l) <= target ? l : -1;
    return l;
  }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
