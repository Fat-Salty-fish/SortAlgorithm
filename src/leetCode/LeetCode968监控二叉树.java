package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/11/24
 */
public class LeetCode968监控二叉树 {

    /**
     * 这也能动态规划？
     *
     * @param root
     * @return
     */
    public int minCameraCover(TreeNode root) {
        int[] resultArray = dfs(root);
        return resultArray[1];
    }

    /**
     * 树形DP
     * 三种状态：
     * 状态0：必须要在根节点上放置摄像机时覆盖整棵树的摄像头数
     * 状态1：覆盖整棵树时的最少摄像头数 不论根节点是否放置
     * 状态2：覆盖两棵子数的最少摄像头数 不论根节点是否被覆盖
     * <p>
     * 所以 当前root
     * 状态0 = 1 + l2 + r2
     * 状态1 = Math.min(状态0,Math.min(l0+r1,l1+r0))
     * 状态2 = Math.min(状态0,l1+r1)
     *
     * @param root
     * @return
     */
    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE / 2, 0, 0};
        }
        int[] leftResult = dfs(root.left);
        int[] rightResult = dfs(root.right);
        int[] result = new int[3];
        result[0] = 1 + leftResult[2] + rightResult[2];
        result[1] = Math.min(result[0],Math.min(leftResult[0] + rightResult[1],leftResult[1] + rightResult[0]));
        result[2] = Math.min(result[0],leftResult[1] + rightResult[1]);
        return result;
    }
}
