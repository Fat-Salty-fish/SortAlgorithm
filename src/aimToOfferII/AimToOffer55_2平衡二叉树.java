package aimToOfferII;

import leetCode.TreeNode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/5/10
 */
public class AimToOffer55_2平衡二叉树 {


    /**
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return check(root).isBalanced;
    }

    public ReturnType check(TreeNode root) {
        if (root == null) {
            return new ReturnType();
        }
        ReturnType left = check(root.left);
        ReturnType right = check(root.right);
        ReturnType result = new ReturnType();
        if (!left.isBalanced || !right.isBalanced || Math.abs(left.depth - right.depth) > 1) {
            result.setBalanced(false);
        }
        result.setDepth(Math.max(left.depth, right.depth) + 1);
        return result;
    }


    class ReturnType {

        boolean isBalanced;

        int depth;

        public ReturnType() {
            this.isBalanced = true;
            this.depth = 0;
        }

        public boolean isBalanced() {
            return isBalanced;
        }

        public void setBalanced(boolean balanced) {
            isBalanced = balanced;
        }

        public int getDepth() {
            return depth;
        }

        public void setDepth(int depth) {
            this.depth = depth;
        }
    }

}
