package leetCode;

import sun.nio.cs.FastCharsetProvider;

/**
 * @author acer
 * @Date 2019/7/26 12:11
 */
public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return check(root.left,root.right);
    }

    public boolean check(TreeNode leftNode, TreeNode rightNode){
        if(leftNode == null && rightNode == null)
            return true;
        else if (leftNode == null || rightNode == null){
             return false;
        }
        return (leftNode.val == rightNode .val) && check(leftNode.left,rightNode.right) && check(leftNode.right,rightNode.left);
    }
}
