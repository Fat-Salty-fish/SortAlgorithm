package leetCode;

/**
 * @author acer
 * @Date 2019/5/4 11:10
 */
public class LeetCode104 {
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
}
