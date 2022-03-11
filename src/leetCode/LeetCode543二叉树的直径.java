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
     *
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

    /**
     * 树形dp
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree2(TreeNode root) {
        return maxDistance(root).maxDistance - 1;
    }

    public ReturnType maxDistance(TreeNode root) {
        if (root == null) {
            return new ReturnType(0, 0);
        }
        ReturnType left = maxDistance(root.left);
        ReturnType right = maxDistance(root.right);
        int depth = Math.max(left.depth, right.depth) + 1;
        int maxDistance = Math.max(Math.max(left.maxDistance, right.maxDistance), left.depth + right.depth + 1);
        return new ReturnType(depth, maxDistance);
    }

    public class ReturnType {
        public int depth;

        public int maxDistance;

        public ReturnType(int depth, int maxDistance) {
            this.depth = depth;
            this.maxDistance = maxDistance;
        }
    }
}
