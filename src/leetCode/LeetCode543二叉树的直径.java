package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2020/12/7
 */
public class LeetCode543二叉树的直径 {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        depth(root);
        return max;
    }

    /**
     * 计算节点的最大深度
     * 而题目本身是要返回最大的路径长度
     * @param root
     * @return
     */
    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        max = Math.max(leftDepth + rightDepth, max);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
