package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/22
 */
public class LeetCode404左叶子之和 {

    /**
     * 左叶子节点 首先是叶子节点 并且是父亲节点的左子节点
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root,false);
    }

    /**
     * 左叶子节点之和 必须知道自己是否为左叶子节点
     *
     * @param root
     * @param isLeftChild
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root, boolean isLeftChild) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null && isLeftChild) {
            return root.val;
        } else {
            return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
        }
    }
}
