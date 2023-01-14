package GuCheng.Fundmental.Algo.B_BFS;

import java.util.ArrayList;
import java.util.List;

public class ReverseOddLevelsOfBinaryTree {
    public TreeNode reverseOddLevels(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int depth = 0;
        while (!list.isEmpty()) {
            if (depth % 2 == 1) {
                List<Integer> temp = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    temp.add(list.get(i).val);
                }

                for (int i = 0; i < list.size(); i++) {
                    list.get(i).val = temp.get(list.size() - i - 1);
                }
            }

            List<TreeNode> nextLayer = new ArrayList<>();

            for (int i = 0; i < list.size(); i++) {
                TreeNode node = list.get(i);
                if (node.left != null) {
                    nextLayer.add(node.left);
                }

                if (node.right != null) {
                    nextLayer.add(node.right);
                }
            }

            depth++;
            list = nextLayer;
        }

        return root;
    }


}
