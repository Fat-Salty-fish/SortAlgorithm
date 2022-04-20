package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/22
 */
public class LeetCode156上下翻转二叉树 {
    /**
     * 上下翻转二叉树 感觉更像是旋转二叉树
     * 如何旋转一个二叉树呢
     * @param root
     * @return
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null){
            return null;
        }
        if (root.left == null){
            return root;
        }
        TreeNode result = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return result;
    }
}
