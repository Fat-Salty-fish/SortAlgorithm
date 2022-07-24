package aimToOfferII;

import leetCode.TreeNode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/5/9
 */
public class AimToOffer55_1二叉树的深度 {

    int depth = 0;


    public int maxDepth(TreeNode root) {
        findDepth(root, 1);
        return depth;
    }

    public void findDepth(TreeNode root, int currentDepth) {
        if (root == null) {
            return;
        }
        depth = Math.max(depth, currentDepth);
        findDepth(root.left, currentDepth + 1);
        findDepth(root.right, currentDepth + 1);
    }
}
