package leetCode;

/**
 * @author acer
 * @Date 2019/5/4 11:10
 */
public class LeetCode104二叉树的最大深度 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int result = 0;
        return currentDepth(root);
    }

    public int currentDepth(TreeNode currentRoot){
        if(currentRoot == null){
            return 0;
        }else {
            int leftDepth = 1 + currentDepth(currentRoot.left);
            int rightDepth = 1 + currentDepth(currentRoot.right);
            return leftDepth>=rightDepth?leftDepth:rightDepth;
        }

    }

    /**
     * 与543题异曲同工
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root){
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth2(root.left);
        int rightMax = maxDepth2(root.right);
        return Math.max(leftMax, rightMax) + 1;
    }

}
