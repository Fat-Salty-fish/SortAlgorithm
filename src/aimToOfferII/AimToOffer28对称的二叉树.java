package aimToOfferII;

import leetCode.TreeNode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/31
 */
public class AimToOffer28对称的二叉树 {

    /**
     * 对称二叉树
     * 如果一棵二叉树和它的镜像是相同的 那么是一棵对称的二叉树
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }


    /**
     * 检查两个子树是否为镜像
     *
     * @param leftRoot
     * @param rightRoot
     * @return
     */
    public boolean check(TreeNode leftRoot, TreeNode rightRoot) {
        if (leftRoot == null && rightRoot == null) {
            return true;
        }
        if (leftRoot == null || rightRoot == null) {
            return false;
        }
        return leftRoot.val == rightRoot.val && check(leftRoot.left, rightRoot.right) && check(leftRoot.right, rightRoot.left);
    }
}
