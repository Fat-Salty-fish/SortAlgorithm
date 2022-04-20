package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/22
 */
public class LeetCode270最接近的二叉搜索树值 {

    /**
     * 中序遍历
     *
     * @param root
     * @param target
     * @return
     */
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return Integer.MAX_VALUE / 2;
        }
        int leftClosest = root.left == null ? Integer.MAX_VALUE / 2 : closestValue(root.left, target);
        int rightClosest = root.right == null ? Integer.MAX_VALUE / 2 : closestValue(root.right, target);

        int closest = Math.abs(leftClosest - target) < Math.abs(rightClosest - target) ? leftClosest : rightClosest;
        closest = Math.abs(closest - target) < Math.abs(root.val - target) ? closest : root.val;
        return closest;
    }
}
