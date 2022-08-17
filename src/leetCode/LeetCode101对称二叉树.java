package leetCode;


/**
 * @author acer
 * @Date 2019/7/26 12:11
 */
public class LeetCode101对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return check(root.left,root.right);
    }

    public boolean check(TreeNode leftNode, TreeNode rightNode){
        if(leftNode == null && rightNode == null) {
            return true;
        } else if (leftNode == null || rightNode == null){
             return false;
        }
        return (leftNode.val == rightNode .val) && check(leftNode.left,rightNode.right) && check(leftNode.right,rightNode.left);
    }

    /**
     * 对称二叉树
     * 怎么定义一个对称二叉树呢
     * 需要判断两个子节点以及四个孙子节点的值
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check2Node(root.left, root.right);
    }

    public boolean check2Node(TreeNode firstNode, TreeNode secondNode) {
        if (firstNode == null && secondNode == null) {
            return true;
        }
        if (firstNode == null || secondNode == null) {
            return false;
        }
        return (firstNode.val == secondNode.val) && check2Node(firstNode.left, secondNode.right) && check2Node(firstNode.right, secondNode.left);
    }
}
