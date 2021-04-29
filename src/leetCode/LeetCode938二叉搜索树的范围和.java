package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/4/27
 */
public class LeetCode938二叉搜索树的范围和 {

    /**
     * 计算二叉搜索树中所有
     *
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
