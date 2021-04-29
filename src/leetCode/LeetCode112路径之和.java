package leetCode;

/**
 * @author acer
 * @Date 2019/7/26 19:11
 */
public class LeetCode112路径之和 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        int current = sum - root.val;
        //减多了 无法实现
        if (root.left == null && root.right == null) {
            return current == 0;
        }
        //剩余数值依然大于零 则继续向下计算
        else {
            return hasPathSum(root.left, current) || hasPathSum(root.right, current);
        }
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        int temp = sum - root.val;
        if (root.left == null && root.right == null) {
            return temp == 0;
        }
        return hasPathSum2(root.left, temp) || hasPathSum2(root.right, temp);
    }



    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(-2);
        TreeNode node2 = new TreeNode(-3);
        int sum = -5;
        node1.right = node2;
        System.out.println(new LeetCode112路径之和().hasPathSum(node1, sum));
    }
}

