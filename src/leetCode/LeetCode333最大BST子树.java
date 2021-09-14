package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/7
 */
public class LeetCode333最大BST子树 {


    /**
     * 用来表示上一次中序遍历后的中点
     */
    public Long lastMidNum = Long.MIN_VALUE;


    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (validBST(root, Long.MIN_VALUE, Long.MAX_VALUE)) {
            return getTreeSize(root);
        }else {
            return Math.max(largestBSTSubtree(root.left),largestBSTSubtree(root.right));
        }
    }


    /**
     * 验证二叉搜索树
     *
     * @param root
     * @param leftBarrier
     * @param rightBarrier
     * @return
     */
    public boolean validBST(TreeNode root, long leftBarrier, long rightBarrier) {
        if (root == null) {
            return true;
        }
        if (root.val <= leftBarrier || root.val >= rightBarrier) {
            return false;
        }
        return validBST(root.left, leftBarrier, root.val) && validBST(root.right, root.val, rightBarrier);
    }

    /**
     * 获取树的大小
     *
     * @param root
     * @return
     */
    public int getTreeSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + getTreeSize(root.left) + getTreeSize(root.right);
    }
}
