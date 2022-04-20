package aimToOfferII;

import leetCode.TreeNode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/31
 */
public class AimToOffer27二叉树的镜像 {

    /**
     * 镜像二叉树
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode mirrorHead = new TreeNode(root.val);
        mirrorHead.left = mirrorTree(root.right);
        mirrorHead.right = mirrorTree(root.left);
        return mirrorHead;
    }
}
