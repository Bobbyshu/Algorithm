package Leetcode.weeklycontest.Normal.NO335;

public class t2 {
  /**
  public long kthLargestLevelSum(TreeNode root, int k) {
    List<Long> list = new ArrayList<>();
    Deque<TreeNode> q = new ArrayDeque<>();
    if (root == null) {
      return -1;
    }

    q.add(root);
    while (!q.isEmpty()) {
      int size = q.size();
      long sum = 0;
      for (int i = 0; i < size; ++i) {
        TreeNode cur = q.poll();
        sum += cur.val;
        if (cur.left != null) {
          q.add(cur.left);
        }
        if (cur.right != null) {
          q.add(cur.right);
        }
      }
      list.add(sum);
    }

    if (list.size() < k) {
      return -1;
    }
    Collections.sort(list, Collections.reverseOrder());
    // System.out.println(list);
    return list.get(k - 1);
  }
   **/
}

