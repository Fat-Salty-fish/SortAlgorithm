package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/4/9
 */
public class LeetCode701二叉搜索树中的插入操作 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 如果当前节点为空 则可以直接构造新的节点并返回
        if (root == null) {
            return new TreeNode(val);
        }
        // val值大于当前节点 插入的节点一定在右子树
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
