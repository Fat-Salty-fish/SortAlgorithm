package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/24
 */
public class LeetCode1448统计二叉树中好节点的数目 {

    public int goodNodes(TreeNode root) {
        return goodNodesHelp(root, Integer.MIN_VALUE);
    }

    public int goodNodesHelp(TreeNode root, int parentVal) {
        int result = 0;
        if (root == null) {
            return result;
        }
        if (root.val >= parentVal) {
            result++;
        }
        int maxValue = Math.max(parentVal, root.val);
        return result + goodNodesHelp(root.left, maxValue) + goodNodesHelp(root.right, maxValue);
    }
}
