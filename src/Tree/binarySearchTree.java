package Tree;

public class binarySearchTree {

    // 在BST中增加一个新节点
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 找到空位置插入新节点
        if (root == null)
            return new TreeNode(val);

        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }

        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }

    //删除
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (root.val == key) {
            //左右都只有一个孩子或者左右都没有孩子的情况
            if (root.left == null)
                return root.right;

            if (root.right == null)
                return root.left;

            //左右两个孩子都有的情况
            //获得右子树最小的节点（或者左子树最大的节点）
            TreeNode minNode = getMin(root.right);
            // 删除右子树最小的节点
            root.right = deleteNode(root.right, minNode.val);
            //用右子树最小的节点替换root节点
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    TreeNode getMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    // 查找
    public TreeNode searchBST(TreeNode root, int val) {
        //递归写法
        if (root == null)
            return null;

        if (root.val == val) {
            return root;
        }

        TreeNode left = searchBST(root.left, val);
        TreeNode right = searchBST(root.right, val);

        return left == null ? right : left;

        //迭代写法
        /*
        while (root != null) {
            if (val < root.val) {
                root = root.left;
            } else if (val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
         */
    }
}
