package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/4/4
 */
public class LeetCode450删除二叉搜索树中的节点 {

    /**
     * 删除二叉搜索树中的节点
     * 根据key查询目标的二叉搜索树：二分查找
     * 查找到目标节点后 需要寻找节点来代替当前节点
     * 代替节点：目标节点的左子树的中序遍历最后一个遍历到的节点 (左子树的前序节点)
     * 或者目标节点右子树的中序遍历第一个遍历的节点 (右子树的后续节点)
     *
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        // 当前节点为空节点 直接返回空
        if (root == null) {
            return null;
        }
        // key大于根节点val 需要在右子树里删除目标节点
        // key小于根节点val 需要在左子树里删除目标节点
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            // key等于节点val 则需要删除本节点 查找替换节点
            // 如果本节点左子树为空 则直接使用右子节点代替本节点
            // 如果本节点右子树为空 则直接使用左子节点代替本节点
            // 两棵子树都不为空 两个办法：查找左子树的前序节点 并删除（递归调用）或查找右子树的后续节点 并删除（递归调用）
            // 或查找右子树的后续节点 将本节点的左子树 直接移动到后续节点的左子树上 然后使用当前节点的右子节点作为根节点
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode current = root.right;
                // 查询当前节点的右子树的后续节点
                while (current.left != null) {
                    current = current.left;
                }
                // 当前节点的左子树直接移动到后续节点的左子树 当前节点左子树设置为空
                current.left = root.left;
                root.left = null;
                return root.right;
            }
        }
        return root;
    }
}
