package leetCode;

/**
 * @author acer
 * @Date 2019/7/26 0:03
 */
public class LeetCode124 {
    //多半是要用到动态规划了
    //结果没有用到动态规划
    private int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxValue;
    }

    public int maxGain(TreeNode node) {
        //如果节点为空 则返回0
        if (node == null) {
            return 0;
        }
        //获取左子节点的最大路径和
        int leftGain = Math.max(maxGain(node.left), 0);
        //获取右子节点的最大路径和
        int rightGain = Math.max(maxGain(node.right), 0);
        //获取当前总的最大路径和
        int price_newPath = node.val + leftGain + rightGain;

        //当前最大路径和和现在最大路径和进行比较
        maxValue = Math.max(maxValue, price_newPath);

        return node.val + Math.max(leftGain, rightGain);
    }

}
