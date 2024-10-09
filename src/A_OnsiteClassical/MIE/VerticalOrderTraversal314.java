package A_OnsiteClassical.MIE;

import java.util.*;

public class VerticalOrderTraversal314 {
  public List<List<Integer>> verticalOrderBFS(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }

    Map<Integer, List<Integer>> map = new HashMap<>();
    Deque<TreeNode> q = new ArrayDeque<>();
    Deque<Integer> col = new ArrayDeque<>();
    int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
    q.add(root);
    col.add(0);
    // map.putIfAbsent(0, new ArrayList<>());
    // map.get(0).add(root);

    while (!q.isEmpty()) {
      TreeNode cur = q.pollFirst();
      int curCol = col.pollFirst();
      left = Math.min(left, curCol);
      right = Math.max(right, curCol);

      map.putIfAbsent(curCol, new ArrayList<>());
      map.get(curCol).add(cur.val);

      if (cur.left != null) {
        q.addLast(cur.left);
        col.addLast(curCol - 1);
      }

      if (cur.right != null) {
        q.addLast(cur.right);
        col.addLast(curCol + 1);
      }
    }

    for (int i = left; i <= right; ++i) {
      res.add(new ArrayList<>(map.get(i)));
    }

    return res;
  }

  private void dfs(TreeNode node, int row, int col, Map<Integer, Map<Integer, List<Integer>>> res) {
    if (node != null) {
      // 更新哈希表，存储每一列中的节点值
      res.computeIfAbsent(col, k -> new HashMap<>())
          .computeIfAbsent(row, k -> new ArrayList<>())
          .add(node.val);

      // 左子节点列号减1，右子节点列号加1
      dfs(node.left, row + 1, col - 1, res);
      dfs(node.right, row + 1, col + 1, res);
    }
  }

  // 主函数，返回垂直遍历的结果
  public List<List<Integer>> verticalOrderDFS(TreeNode root) {
    // 创建哈希表，用于存储列 -> 行 -> 节点值
    Map<Integer, Map<Integer, List<Integer>>> res = new HashMap<>();
    // 调用深度优先搜索函数
    dfs(root, 0, 0, res);

    // 最终结果的列表
    List<List<Integer>> finalRes = new ArrayList<>();
    // 获取所有的列并按列号升序排序
    List<Integer> sortedCols = new ArrayList<>(res.keySet());
    Collections.sort(sortedCols);

    // 对每个列进行处理
    for (Integer col : sortedCols) {
      Map<Integer, List<Integer>> rowMap = res.get(col);
      List<Integer> sortedRows = new ArrayList<>(rowMap.keySet());
      Collections.sort(sortedRows); // 行号升序排序

      List<Integer> columnValues = new ArrayList<>();
      // 对每个行中的节点值按顺序添加到列中
      for (Integer row : sortedRows) {
        columnValues.addAll(rowMap.get(row));
      }

      // 将该列的值添加到最终结果中
      finalRes.add(columnValues);
    }

    return finalRes;
  }
}
