package A_OnsiteClassical.Tiktok;

public class NO426_ConvertBSTtoDoubleLL {
  Node prev = null;
  public Node treeToDoublyList(Node root) {
    if (root == null) return null;
    Node dummy = new Node(0, null, null);
    prev = dummy;
    helper(root);
    //connect head and tail
    prev.right = dummy.right;
    dummy.right.left = prev;
    return dummy.right;
  }

  private void helper (Node cur) {
    if (cur == null) return;
    helper(cur.left);
    prev.right = cur;
    cur.left = prev;
    prev = cur;
    helper(cur.right);
  }
}

class Node {
  public int val;
  public Node left;
  public Node right;

  public Node() {}

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val,Node _left,Node _right) {
    val = _val;
    left = _left;
    right = _right;
  }
};
