package DataStructure.Tree.Traverse;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InOrderTraverse {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.addLast(cur);
                cur = cur.left;
            } else {
                cur = stack.pollLast();
                res.add(cur.val);
                cur = cur.right;
            }
        }

        return res;
    }
}
