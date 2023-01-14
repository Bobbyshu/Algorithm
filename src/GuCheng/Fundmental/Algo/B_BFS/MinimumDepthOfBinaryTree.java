package GuCheng.Fundmental.Algo.B_BFS;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; ++i) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            ++depth;
        }

        return depth;
    }
}
