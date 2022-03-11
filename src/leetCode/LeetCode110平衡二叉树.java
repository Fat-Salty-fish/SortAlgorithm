package leetCode;

/**
 * @author acer
 * @Date 2019/7/26 14:48
 */
public class LeetCode110平衡二叉树 {
    //要判断一个二叉树是不是平衡二叉树 只要计算这个二叉树的左右子树的高度差是否超过了1
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 二刷 原来的方法时间复杂度比较高
     *
     * @param root
     * @return
     */
    public boolean isBalanced2(TreeNode root) {
        return check(root).isBalanced;
    }

    /**
     * 检查是否为平衡二叉树
     *
     * @param root
     * @return
     */
    public ReturnType check(TreeNode root) {
        if (root == null) {
            return new ReturnType(0, true);
        }
        ReturnType left = check(root.left);
        ReturnType right = check(root.right);
        int depth = Math.max(left.depth, right.depth) + 1;
        boolean isBalance = Math.abs(left.depth - right.depth) <= 1 && left.isBalanced && right.isBalanced;
        return new ReturnType(depth, isBalance);
    }

    /**
     * 返回类型
     */
    public class ReturnType {
        public int depth;

        public boolean isBalanced;

        public ReturnType(int depth, boolean isBalanced) {
            this.depth = depth;
            this.isBalanced = isBalanced;
        }
    }

}
