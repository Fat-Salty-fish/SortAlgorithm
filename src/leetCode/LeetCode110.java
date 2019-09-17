package leetCode;

/**
 * @author acer
 * @Date 2019/7/26 14:48
 */
public class LeetCode110 {
    //要判断一个二叉树是不是平衡二叉树 只要计算这个二叉树的左右子树的高度差是否超过了1
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        return Math.abs(depth(root.left) - depth(root.right)) <=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        return Math.max(leftDepth,rightDepth)+1;
    }
}
