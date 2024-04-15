package A_OnsiteClassical.Tree;

public class BinaryTreePaths {
//  List<String> res;
//
//  public List<String> binaryTreePaths(TreeNode root) {
//    res = new ArrayList<>();
//…        if (root.left == null && root.right == null) {
//      res.add(path + root.val);
//      return;
//    }
//
//    dfs(root.left, path + root.val + "->");
//    dfs(root.right, path + root.val + "->");
//  }


//  List<String> res;
//  // StringBuilder sb;
//  public List<String> binaryTreePaths(TreeNode root) {
//    res = new ArrayList<>();
//    StringBuilder sb = new StringBuilder();
//    dfs(root, sb);
//
//    return res;
//  }
//
//  void dfs(TreeNode root, StringBuilder sb) {
//    if (root == null) {
//      return;
//    }
//
//    int n = sb.length();
//    if (root.left == null && root.right == null) {
//      sb.append(root.val);
//      res.add(sb.toString());
//      sb.setLength(n);
//      return;
//    }
//
//    sb.append(root.val);
//    sb.append("->");
//    dfs(root.left, sb);
//    dfs(root.right, sb);
//    sb.setLength(n);
//  }
}
