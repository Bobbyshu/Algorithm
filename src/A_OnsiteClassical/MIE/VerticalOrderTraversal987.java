package A_OnsiteClassical.MIE;

import java.util.*;

public class VerticalOrderTraversal987 {
  public List<List<Integer>> verticalTraversal(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
    dfs(root, map, 0, 0);
    for (int col: map.keySet()) {
      List<Integer> temp = new ArrayList<>();
      for (int row : map.get(col).keySet()) {
        PriorityQueue<Integer> pq = map.get(col).get(row);
        while (!pq.isEmpty()) {
          temp.add(pq.poll());
        }
      }
      res.add(new ArrayList<>(temp));
    }
    return res;
  }

  private void dfs(TreeNode root, Map<Integer, Map<Integer, PriorityQueue<Integer>>> map, int row, int col) {
    if (root == null) return;
    map.putIfAbsent(col, new TreeMap<>());
    map.get(col).putIfAbsent(row, new PriorityQueue<>());
    map.get(col).get(row).add(root.val);
    dfs(root.left, map, row + 1, col - 1);
    dfs(root.right, map, row + 1, col + 1);
  }
}
